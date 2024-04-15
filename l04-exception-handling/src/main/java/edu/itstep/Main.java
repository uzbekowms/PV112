package edu.itstep;

import edu.itstep.exception.EntityNotFoundException;
import edu.itstep.model.User;

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
//        System.out.println(getFirstLineOfFile("C:\\Users\\teacher\\Deskto\\Лаба.txt")); // null
//        getUser(5);
//        System.out.println(convertStringToInt(null));
//        f(5);
        method1();
        method2();
    }

    private static void method1() {

    }

    private static void method2() {
        method3();
        method4();
    }

    private static void method3() {

    }

    private static void method4() {
        method5();
    }

    private static void method5() {
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        for (StackTraceElement element : stackTraceElements) {
            System.out.println(element.getMethodName());
        }
    }

    private static int convertStringToInt(String s) {
        return Integer.parseInt(s);
    }

    private static int f(int number) {
        if (number <= 1) {
            throw new RuntimeException("heh");
        }

        return number * f(number - 1);
    }


    private static String getFirstLineOfFile(String fileName) throws IOException, ArithmeticException {
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

    private static String getUser(int id) throws EntityNotFoundException {
        throw new EntityNotFoundException("Cannot find user with id: " + id);
    }

    private static boolean updateUser(int id, User user) {
        // pre
        if (id > 1000) {
            throw new IllegalArgumentException("Id cannot be greater than 1000");
        }

        // update user

        // post
        return false;
    }

    private static void loginAdminPanelBad(boolean hasConnection, boolean isLogged, boolean isAdmin) {
        if (hasConnection) {
            if (isLogged) {
                if (isAdmin) {
                    System.out.println("Admin panel");
                } else {
                    System.out.println("Access denied");
                }
            } else {
                System.out.println("Login pls");
            }
        } else {
            System.out.println("No connection");
        }
    }

    private static void loginAdminPanelGood(boolean hasConnection, boolean isLogged, boolean isAdmin) {
        if (!hasConnection) {
            System.out.println("No connection");
            return;
        }
        if (!isLogged) {
            System.out.println("Login pls");
            return;
        }
        if (!isAdmin) {
            System.out.println("Access denied");
            return;
        }

        System.out.println("Admin panel");
    }
}

// Checked Exception -> Exception
// Unchecked Ex -> RuntimeException
