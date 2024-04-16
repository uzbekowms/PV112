package com.company;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeSet;

public class TreeSetDemo {
    CarsComparator carsComparator = new CarsComparator();
    TreeSet<Car> cars = new TreeSet<>(carsComparator);

    public static void main(String[] args) {
        TreeSetDemo t = new TreeSetDemo();
        t.run();
    }

    void run() {
        Car car1 = new Car("Ferrary", 12000, 1988);
        Car car2 = new Car("Ford", 13000, 1955);
        Car car3 = new Car("Toyota", 13500, 2003);
        Car car4 = new Car("Citroen", 12000, 2014);
        Car car5 = new Car("Mercedes-Benz", 15000, 2011);
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);
        cars.add(car5);
        System.out.println("Сортування по роках: " + cars);
        //Зворотній компаратор для TreeSet(Java8)
        TreeSet<Car> ts2 = new TreeSet<>(carsComparator.reversed());
        ts2.addAll(cars); //додати вміст попереднього TreeSet у новий
        System.out.println("Зворотнє сортування:" + ts2);
    }
}
