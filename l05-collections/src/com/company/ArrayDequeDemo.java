package com.company;

import java.util.ArrayDeque;

public class ArrayDequeDemo {

    public static void main(String[] args) {
        ArrayDeque<String> numbers = new ArrayDeque<>();

        System.out.println("Використання в якості стеку");
        numbers.push("Перший"); // метод інтерфуйсу Deque
        numbers.push("Другий");
        numbers.push("Третій");
        System.out.println("Перший елемент ArrayDeque: " + numbers.getFirst());//Отримуємо перший елемент, але не видаляємо
        System.out.println("Вміст ArrayDeque: " + numbers);
        System.out.println(numbers.pop()); //Отримуємо і видаляємо з вершини стеку
        System.out.println(numbers.pop()); //еквівалентно до removeFirst()
        System.out.println(numbers.pop());
        //System.out.println(ad.pop()); //ArrayDeque порожній видасть NoSuchElementException
        System.out.println();
        System.out.println("Використання в якості черги");

        numbers.offer("Перший");
        numbers.offer("Другий");
        numbers.offer("Третій");
        System.out.println("Перший елемент ArrayDeque: " + numbers.getFirst());//Отримуємо перший елемент, але не видаляємо
        System.out.println("Вміст ArrayDeque: " + numbers);
        System.out.println(numbers.poll()); //витягнути і видалити з голови
        System.out.println(numbers.poll());
        System.out.println(numbers.poll());
        System.out.println(numbers.poll());
    }
}
