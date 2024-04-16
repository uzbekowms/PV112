package com.company;

import java.util.*;

import static java.util.Collections.max;

public class CollectionsMethodsDemo {

    public static void main(String[] args) {
        List<Integer> a = Arrays.asList(0, 1, 2, 3, 3, -4);
        System.out.println(max(a)); // 3
        System.out.println(Collections.min(a)); // -4
        System.out.println(Collections.frequency(a, 2)); // 1 раз
        System.out.println(Collections.frequency(a, 3)); // 2 рази
        Collections.reverse(a);   // змінюємо порядок елементів на протилежний
        System.out.println(a);    // [-4, 3, 3, 2, 1, 0]
        Collections.rotate(a, 3); // зсуває список циклічно на 3 елементи
        System.out.println(a);    // [2, 1, 0, -4, 3, 3]
        List<Integer> sublist = Collections.nCopies(2, 3); // новий список містить 2 трійки
        System.out.println(Collections.indexOfSubList(a, sublist)); // 4
        Collections.shuffle(a);   // "тасуємо" елементи
        System.out.println(a);    // елементи в довільному порядку
        Collections.sort(a);
        System.out.println(a);    // [-4, 0, 1, 2, 3, 3]
        List<Integer> b = new ArrayList<>(a);
        Collections.fill(b, 8);
        System.out.println(b);    // [8, 8, 8, 8, 8, 8]
        Collections.copy(b, a);
        System.out.println(b);    // [-4, 0, 1, 2, 3, 3]
        System.out.println(Collections.binarySearch(b, 2)); // 3
        Collections.swap(b, 0, 5);
        System.out.println(b);    // [3, 0, 1, 2, 3, -4]
        Collections.replaceAll(b, 3, 10);
        System.out.println(b);    // [10, 0, 1, 2, 10, -4]
    }
}
