package org.example;

import lombok.SneakyThrows;
import lombok.extern.java.Log;
import org.example.entity.Student;

import java.io.FileInputStream;
import java.io.InputStream;

@Log
public class Main {


    @SneakyThrows
    public static void main(String[] args) {
//        @Cleanup
//        InputStream inputStream = new FileInputStream("test.txt");
//
//        @Cleanup("closeThisService")
//        UserService userService = new UserService();

        InputStream inputStream = new FileInputStream("test.txt");

        Student sas = Student.builder()
                .id(2)
                .name("Sas")
                .build();

        System.out.println(sas);
        log.info(sas.toString());
    }
}
