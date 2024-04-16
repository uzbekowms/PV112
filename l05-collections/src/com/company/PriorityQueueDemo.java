package com.company;

import java.util.PriorityQueue;

public class PriorityQueueDemo {

    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(11);
        priorityQueue.add(750);
        priorityQueue.add(50);
        priorityQueue.offer(1);
        priorityQueue.add(300);
        priorityQueue.add(25);
        priorityQueue.add(2);
        priorityQueue.offer(20);
        priorityQueue.add(5);
        priorityQueue.add(40);
        System.out.println("Порядок зберігання елементів" + priorityQueue);

        // Отримуємо і видаляємо елемент з голови черги
        while (!priorityQueue.isEmpty()) {
            System.out.println("Отримали: " + priorityQueue.poll());
            System.out.println("Новий порядок:" + priorityQueue);
        }
    }
}
