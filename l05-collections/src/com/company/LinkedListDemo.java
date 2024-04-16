package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.TreeSet;

public class LinkedListDemo {

    private final LinkedList<Car> cars = new LinkedList<>();

    public static void main(String[] args) {
        LinkedListDemo linkedListDemo = new LinkedListDemo();
        linkedListDemo.seedCars();

    }

    private void seedCars() {
        Car ferrary = new Car("Ferrary", 10800, 1995);
        Car lada = new Car("Lada", 2600, 1989);
        cars.add(ferrary);
        cars.add(lada);

        //додаємо в початок списку
        cars.addFirst(new Car("Alfa Romeo 155", 11678, 2000));
        cars.remove(lada); // видалити обєкт
        System.out.printf("Після видалення lada: %s\n\n", cars);

        cars.remove(1); //видалити елемент за індексом
        System.out.printf("Після видалення першого елементу: %s\n\n", cars);

        Car myCar = cars.get(0);
        System.out.printf("Отриманий елемент за індексом [0]: %s\n\n", myCar);

        cars.set(0, ferrary); //замінити елемент за індексом
        System.out.printf("Замінений елемент за індексом [0]: %s\n\n", cars.get(0));

        ArrayList<Car> carsArray = new ArrayList<Car>();
        carsArray.add(ferrary);
        carsArray.add(lada);
        cars.addAll(carsArray); //додаємо вміст ArrayList у наш LinkedList
        System.out.printf("Після додавання ArrayList: %s\n\n", cars);
    }
}

