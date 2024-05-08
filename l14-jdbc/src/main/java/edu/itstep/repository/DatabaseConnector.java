package edu.itstep.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class DatabaseConnector {

    protected Connection connection;
    private final String dbUser = "root";
    private final String dbPass = "";
    private final String connectionString = "jdbc:mysql://localhost:3306/studentsdb";


    public DatabaseConnector() throws SQLException, ClassNotFoundException {
        System.out.println("Start Connection");
        Class.forName("com.mysql.cj.jdbc.Driver");
        this.connection = DriverManager.getConnection(connectionString, dbUser, dbPass);
        System.out.println("End connection");
    }
}
