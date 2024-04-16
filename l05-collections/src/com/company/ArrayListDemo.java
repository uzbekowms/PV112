package com.company;

import java.util.*;

public class ArrayListDemo {

    private ArrayList<String> stringArrayList;

    public static void main(String[] args) {
//        ArrayListDemo arrayList = new ArrayListDemo();
//        arrayList.create();
//        arrayList.getData();
//        arrayList.iterateData();

        List<String> stringArrayList = Collections.synchronizedList(new ArrayList<>());
        stringArrayList.add("Привіт");
        stringArrayList.add("тобі");
        stringArrayList.add("божевільний");
        stringArrayList.add("світе!");

        synchronized (stringArrayList) {
            Iterator<String> iterator = stringArrayList.iterator();

            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }
        }
    }

    private void create() {
        //створюємо і наповнюємо ArrayList
        stringArrayList = new ArrayList<>();
        stringArrayList.add("Привіт");
        stringArrayList.add("тобі");
        stringArrayList.add("божевільний");
        stringArrayList.add("світе!");
    }

    //читаємо дані по індексу
    private void getData() {
        for (int i = 0; i < stringArrayList.size(); i++) {
            System.out.printf("%s ", stringArrayList.get(i));
        }
    }

    //Читаємо вміст ArrayList з допомогою ітератора
    private void iterateData() {
        ListIterator<String> iterator = stringArrayList.listIterator();
        while (iterator.hasNext()) {
            System.out.printf("%s ", iterator.next());
        }
    }
}
