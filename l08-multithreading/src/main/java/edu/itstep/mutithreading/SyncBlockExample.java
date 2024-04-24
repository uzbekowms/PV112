package edu.itstep.mutithreading;

import java.net.Socket;

public class SyncBlockExample {
    public static void main(String[] args) {
        Object lock = new Object();

        Runnable task = () -> {
            synchronized (lock) {
                System.out.println(Thread.currentThread().getName());
            }
        };
        Thread t1 = new Thread(task);
        t1.start();
        synchronized (lock) {
            for (int i = 0; i < 8; i++) {
                try {
                    Thread.sleep(1000);
                    System.out.print(" " + i);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println(" ...");
        }
    }

    public synchronized int size(){
        return 5;
    }
}
