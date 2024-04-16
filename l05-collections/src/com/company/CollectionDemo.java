package com.company;

import java.util.*;

public class CollectionDemo {

    public static void main(String[] args) {
        // ArrayList
        List<String> a1 = new ArrayList<>();
        a1.add("Зоря");
        a1.add("Марк");
        a1.add("Айан");
        System.out.println(" ArrayList Елементи");
        System.out.print("\t" + a1);

        // LinkedList
        List<String> l1 = new LinkedList<String>();
        l1.add("Зоря");
        l1.add("Марк");
        l1.add("Айан");
        System.out.println();
        System.out.println(" LinkedList Елементи");
        System.out.print("\t" + l1);

        // HashSet
        Set<String> s1 = new HashSet<>();
        s1.add("Зоря");
        s1.add("Марк");
        s1.add("Айан");
        System.out.println();
        System.out.println(" Set Елементи");
        System.out.print("\t" + s1);

        // HashMap
        Map<String, String> m1 = new HashMap<String, String>();
        m1.put("Зоря", "8");
        m1.put("Марк", "31");
        m1.put("Айан", "12");
        m1.put("Дейзі", "14");
        System.out.println();
        System.out.println(" Map Елементи");
        System.out.print("\t" + m1);
    }
}