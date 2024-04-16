package com.company;

import java.util.HashSet;

public class HashSetDemo {

    static HashSet<String> countries = new HashSet<String>();

    public static void main(String[] args) {
        HashSetDemo hashSetDemo = new HashSetDemo();
        hashSetDemo.run();
        //HashSet<String> countriesClose = (HashSet) countries.clone();
    }

    void run() {
        countries.add("Австралія");
        countries.add("Україна");
        countries.add("США");
        System.out.println("1) Три країни: " + countries + " розмір = " + countries.size());
        countries.add("Австралія"); // помилки не буде, але в HashSet нічого не поміняється
        System.out.println("2) Після спроби додати Авcтралію ще раз: " + countries);
        countries.remove("США"); //видаляємо США з множини
        countries.add("Німеччина");
        countries.add("Англія");
        countries.add(null);
        countries.add(null); // другий раз не додаситься
        System.out.println("3)" + countries);
        System.out.println("4) Чи містить множина Німеччину? " + countries.contains("Німеччина"));
        System.out.println("5) Множина пуста? " + countries.isEmpty());
        //можемо також отримати ітератор, або ж перебрати множину у for earch
        for (String str : countries) {
            System.out.println(str);
        }
        countries.clear(); // очистити
        System.out.println("6) Розмір після очищення=" + countries.size());
    }
}

