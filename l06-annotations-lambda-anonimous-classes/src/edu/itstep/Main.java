package edu.itstep;


import edu.itstep.annotation.AnnotationName;
import edu.itstep.model.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.Serializable;
import java.sql.ResultSet;
import java.util.*;
import java.util.function.*;

/**
 * main class
 */
public class Main implements Serializable {
    /**
     * main
     *
     * @param args params
     */
    @AnnotationName(value = "asdasd", name = "Sasha")
    @SuppressWarnings("Unhandled exception: java.io.FileNotFoundException")
    public static void main(@AnnotationName("args") String[] args) {
//        Animal animal = new Animal();
//        System.out.println(animal);
//        Integer i = new Integer(5);
//
//        System.out.println(i);
//
//        @SuppressWarnings("'getYear()' is deprecated")
//        int year = new Date().getYear();
//
//        Calendar instance = Calendar.getInstance();
//        System.out.println(instance.get(Calendar.YEAR));
//        FileInputStream fileInputStream = new FileInputStream("");
//        Group pinkFloyd = new Group() {
//            int a = 4;
//
//            private void test(){}
//            @Override
//            public String bestAlbum() {
//                return "Album";
//            }
//        };
//
//
//        class Test implements Group{
//
//            @Override
//            public String bestAlbum() {
//                return null;
//            }
//        }
//        System.out.println(pinkFloyd.bestAlbum());
//        Group group = new Group() {
//            @Override
//            public String bestAlbum() {
//                element();
//                return "Wish you were here";
//            }
//
//            static void element() {
//
//            }
//        };
//        group.
//        showGroup();
        int x = 5;
        Group group1 = () -> {
            System.out.println(x);
            return "Best album";
        };

        System.out.println(group1.bestAlbum());
        // () -> ...
        // () -> {
        //      ...
        // }
        // param -> ...
        // param -> {
        //      ...
        // }
        // (param1, param2) -> ...
        // (param1, param2) -> {
        //      ...
        // }
//        JButton btn = new JButton("Text");
//        btn.addActionListener((e) -> System.out.println("Button is clicked"));

        List<User> users = new ArrayList<>();
        users.add(new User("Petro", 15));
        users.add(new User("Masha", 84));
        users.add(new User("Ann", 8));
        users.add(new User("Sasha", 50));
        users.add(new User("Joe", 48));
        users.add(new User("Doe", 4));
        Comparator<User> ageComparator = (o1, o2) -> o1.getAge() - o2.getAge();
        Comparator<User> nameComparator = (o1, o2) -> o1.getName().length() - o2.getName().length();

        Collections.sort(users, nameComparator.reversed());

        users.forEach(System.out::println);
        System.out.println("---------------------");
        showFiltered(users, (user) -> user.getName().toLowerCase().contains("o"));
        System.out.println("---------------------");

        Predicate<User> ageGreaterThan18 = (user) -> user.getAge() > 18;

        showFiltered(users, ageGreaterThan18);

//        BinaryOperator
//        UnaryOperator
//        Consumer
//        consumerExample();
        supplierExample();
    }

    private static void consumerExample() {
//        Consumer<String> printConsumer = t -> System.out.println(t.toUpperCase());

        List<String> names = List.of("Petro", "Misha", "Ann", "John", "Doe");
//
//        names.forEach(printConsumer);

        Consumer<List<String>> upperCaseConsumer = list -> {
//            for (int i = 0; i < list.size(); i++) {
//                list.set(i, list.get(i).toUpperCase());
//            }

        };

        int a = 5;


        Predicate<Integer> predicate = (num) -> num % a == 0;


        Consumer<List<String>> printConsumer = list -> list.forEach(System.out::println);

        upperCaseConsumer.andThen(printConsumer).accept(names);
    }

    private static void supplierExample() {
        Supplier<Double> doubleSupplier = () -> Math.random();
        DoubleSupplier doubleSupplier1 = Math::random;

        System.out.println(doubleSupplier.get());
        System.out.println(doubleSupplier.get());
        System.out.println(doubleSupplier.get());
        System.out.println(doubleSupplier.get());
        System.out.println(doubleSupplier.get());
        System.out.println(doubleSupplier1.getAsDouble());

    }

    private static <T> void showFiltered(List<T> list, Predicate<T> predicate) {
        for (T t : list) {
            if (predicate.test(t)) {
                System.out.println(t);
            }
        }
    }

    private static void showGroup(Group group) {
        System.out.println(group.bestAlbum());
    }

    @FunctionalInterface
    interface Group {
        String bestAlbum();
//        String bestAlbum2();
    }


}