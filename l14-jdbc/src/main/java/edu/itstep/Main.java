package edu.itstep;

import edu.itstep.repository.StudentRepository;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //Connectivity
        //Connection
        Class.forName("edu.itstep.Test");
        // DriverManager
        // DataSource
        StudentRepository studentRepository = new StudentRepository();
        studentRepository.test();


//        studentRepository.printStudentById("' OR '' = '");

        // executeQuery - Отримання SELECT
        // executeUpdate - Зміна INSERT UPDATE DELETE
        // execute -

//        studentRepository.executeTest("""
//                SELECT
//                    *
//                FROM
//                    students
//                """);
//
//        studentRepository.executeTest("""
//               INSERT INTO students(first_name, last_name) VALUES ('Test', 'Test')
//                """);

//        System.out.println("Statement================================");
//        studentRepository.printStudentById("' OR '' = '");
//        System.out.println("PreparedStatement================================");
//        studentRepository.prepareStatementExample("' OR '' = '");
//        studentRepository.prepareStatementExample("Max");
        studentRepository.acidExample();
        studentRepository.batchExample();

    }
}
