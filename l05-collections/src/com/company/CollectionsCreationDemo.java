package com.company;

import java.util.*;

public class CollectionsCreationDemo {

    public static void main(String[] args) {
        List<Integer> emptyList = Collections.emptyList();
        System.out.println(emptyList); // []

        List<Integer> singletonList = Collections.singletonList(10);
        System.out.println(singletonList); // [10]

        List<Integer> list = new ArrayList<>(Arrays.<Integer>asList(1, 2, 3));
        List<Integer> unmodifiableList = Collections.unmodifiableList(list);
        Collection<Integer> collection = Collections.unmodifiableCollection(list);
    }
}
