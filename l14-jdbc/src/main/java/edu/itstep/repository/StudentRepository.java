package edu.itstep.repository;

import com.mysql.cj.jdbc.result.CachedResultSetMetaDataImpl;
import edu.itstep.mapper.Student;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JdbcRowSet;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository extends DatabaseConnector {
    public StudentRepository() throws SQLException, ClassNotFoundException {
    }

    public void test() {
        System.out.println(connection);
    }


    public void printStudentById(String name) throws SQLException {
        // Statement
//        PreparedStatement
//        CallableStatement

        String sqlSelect = """
                SELECT
                    *
                FROM
                    students
                WHERE first_name = '%s'
                """.formatted(name);

        System.out.println(sqlSelect);

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sqlSelect);
        List<Student> students = new ArrayList<>();

        while (resultSet.next()) {
            
            System.out.println(resultSet.getString("first_name") + " " + resultSet.getString("last_name"));
        }
    }

    public void executeTest(String sql) throws SQLException {
        Statement statement = connection.createStatement();
        boolean hasResults = statement.execute(sql);
        if (hasResults) {
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()) System.out.println(resultSet.getString("last_name"));
        } else {
            int count = statement.getUpdateCount();
            System.out.println(count);
        }
    }

    public void prepareStatementExample(String name) throws SQLException {
        String query = """
                select * from students where first_name = ?
                """;

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, name);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            System.out.println(resultSet.getString("first_name") + " " + resultSet.getString("last_name"));
        }
    }

    public void resultSetExample() throws SQLException {
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet resultSet = statement.executeQuery("SELECT * FROM students");
        resultSet.moveToInsertRow();
        JdbcRowSet jdbcRowSet = null;
    }


    public void acidExample() throws SQLException {
        connection.setAutoCommit(false);
        Savepoint savepoint = connection.setSavepoint("BEFORE ALL MOVES");
        try (Statement statement = connection.createStatement()) {

            statement.executeUpdate("""
                    insert into students(first_name, last_name) values ('new user', 'new user')
                    """, Statement.RETURN_GENERATED_KEYS);
            ResultSet resultSet = statement.getGeneratedKeys();
            resultSet.next();
            int userId = resultSet.getInt(1);

            System.out.println(5 / 0);

            PreparedStatement preparedStatement = connection.prepareStatement("insert into address(student_id, address) values (?, ?)");
            preparedStatement.setInt(1, userId);
            preparedStatement.setInt(2, 4);
            preparedStatement.execute();
            connection.commit();
        } catch (Exception e) {
            e.printStackTrace();
            connection.rollback(savepoint);
            connection.setAutoCommit(true);
        }
        // зняття коштів з користувача А

        // exception

        // поповнення рахунку користувач Б

        // ACID
        // A - Atomicity
        // C - Consistency
        // I - Isolation
        // D - Durability

        // client insert into
        // phone insert into -> client
        // address insert into


        // phone_id
        // address_id


        // PIB phone_id address_id
        // A 800
        // cashier 1 - 500 = 300
        // cashier 2 + 400 = 1200

        // 800 - 400 400 + 400 = 800

        // min Cashier 2 -> Max


    }

    public void batchExample() throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("""
                INSERT INTO students (first_name, last_name) VALUES (?,?)
                """);


        for (int i = 0; i < 10; i++) {
            preparedStatement.setString(1, "First_name_" + i);
            preparedStatement.setString(2, "Last_name_" + i);
            preparedStatement.addBatch();
        }
        int[] ints = preparedStatement.executeBatch();

        for (int i : ints
        ) {
            System.out.println(i);
        }
        connection.close();
    }
}
