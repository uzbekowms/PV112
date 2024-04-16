package com.company;

import java.util.Objects;
import java.util.Random;

public class Car {

    private String name;
    private double price;
    private int year;

    public Car(String name, double price, int year) {
        this.name = name;
        this.price = price;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Double.compare(price, car.price) == 0 && year == car.year && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return 1;
        //356 - 3 + 5 + 6 = 14 1 + 4 = 5
        // 123 - 1 + 2 + 3 = 6
    }

    @Override
    public String toString() {
        return "\n Car [name=" + name + ", price=" + price + ", year=" + year
                + "]";
    }
}