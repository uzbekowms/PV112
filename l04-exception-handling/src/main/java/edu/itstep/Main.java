package edu.itstep;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        // Exception / Error
        // FileNotFoundException
//        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\file.txt"));
//        String firstLine = reader.readLine();
//        System.out.println(firstLine);
//        Throwable
//        System.out.println(5 / 0);
//        Exception
        // Exception in thread "main"
//        System.out.println(5 / 0);
//        System.out.print("Enter path to file: ");
//        Scanner scanner = new Scanner(System.in);
        System.out.println(getFirstLineOfFile("C:\\Users\\teacher\\Deskto\\Лаба.txt")); // null
    }

    private static String getFirstLineOfFile(String fileName) {
        // try-with-resources
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            try {
                System.out.println("Try");
                return reader.readLine();
            } catch (IOException | ArithmeticException e) {
                System.out.println("Catch");
            } finally {
                if (reader == null) {

                }
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return null;
    }


    private static String tryWithResources(String fileName) {
        // try-with-resources

        try (
                FileReader in = new FileReader(fileName);
                BufferedReader reader = new BufferedReader(in)
        ) {
            System.out.println("Try");
            return reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}
