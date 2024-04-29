package edu.itstep.testing;

public class Calculator {

    public static double sub(double a, double b){
        return a - b;
    }


    public static double add(double a, double b){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return a + b;
    }


    public static double div(double a, double b){
        if (a == 0 || b == 0)
            throw new IllegalArgumentException("A cannot be zero");
        return a / b;
    }


    public static double mul(double a, double b){
        return a * b;
    }

}
