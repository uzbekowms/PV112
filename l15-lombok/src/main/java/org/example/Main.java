package org.example;

import static java.lang.StringTemplate.STR;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        int a = 4;
        System.out.println(STR."Your age \{a}");
    }
}