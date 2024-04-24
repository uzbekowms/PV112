package edu.itstep.mutithreading;

import java.util.concurrent.TimeUnit;

public class SleepExample {
    public static void main(String[] args) {
        //Thread Scheduler
        Runnable task = () -> {
            try {
//                int secondsToWait = 1000 * 60;
//                Thread.sleep(secondsToWait);
                TimeUnit.SECONDS.sleep(60);
                System.out.println("Waked up");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        };
        Thread thread = new Thread(task);
        thread.start();
        thread.interrupt();
    }
}
