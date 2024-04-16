package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
//        List<String> a1 = new ArrayList<>(2);
//        a1.add("Зоря"); // 10 -> 15
//        a1.add("Марк");
//        a1.add("Айан");
//        a1.add("Айан");
//        a1.add("Айан");
//        a1.add("Айан");
//        a1.add("Айан");
//        a1.add("Айан");
//        a1.add("Айан");
//        a1.add(1, "Hello");
//        System.out.println(" ArrayList Елементи");
//        System.out.print("\t" + a1);
//
//        Car car = new Car("Name", 50, 50);
//        Car car2 = new Car("Name", 50, 50);
//        System.out.println();
//        System.out.println(car.hashCode());
//        System.out.println(car2.hashCode());
        Set<Car> stringSet = new HashSet<>();
        Car car = new Car("Name", 60, 40);
        Car car2 = new Car("Name", 40, 60);
        Car car3 = new Car("Name", 50, 50);
        stringSet.add(car);
        stringSet.add(car2);
        stringSet.add(car3);
        System.out.println(car.hashCode());
        System.out.println(car2.hashCode());
        System.out.println(car3.hashCode());
        System.out.println(stringSet);
    }
}
