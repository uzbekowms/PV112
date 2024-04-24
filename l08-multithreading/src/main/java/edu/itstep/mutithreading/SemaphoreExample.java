package edu.itstep.mutithreading;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SemaphoreExample {

    public static void main(String[] args) {
//        SemaphoreRunner semaphoreRunner = new SemaphoreRunner(5000);
//        for (int i = 0; i < 20; i++) {
//            Thread thread = new Thread(semaphoreRunner);
//            thread.start();
//        }
        Lock lock = new ReentrantLock();

        Semaphore semaphore = new Semaphore(0);
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Hello");
    }
}

class SemaphoreRunner implements Runnable {
    private Semaphore semaphore = new Semaphore(5);
    private int counter;

    public SemaphoreRunner(int counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName() + " working...");
            Thread.sleep(counter);
            System.out.println(Thread.currentThread().getName() + " is finished");
            semaphore.release();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}