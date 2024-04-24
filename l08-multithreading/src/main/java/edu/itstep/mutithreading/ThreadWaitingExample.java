package edu.itstep.mutithreading;

import java.util.concurrent.TimeUnit;

public class ThreadWaitingExample {
    public static void main(String[] args) throws InterruptedException {
        Runnable task = () -> {
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                System.out.println("Interrupted");
            }
        };

        Thread thread = new Thread(task);
        thread.start();
        Thread thread1 = new Thread(task);
        thread1.start();
        thread.join(1000);
        thread1.join();
        System.out.println("Finished");
    }
}
