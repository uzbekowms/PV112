package edu.itstep.mutithreading;

public class InterruptedExample {
    public static void main(String[] args) throws InterruptedException {
//        Runnable task = () -> {
//            while (!Thread.currentThread().isInterrupted()) {
//            }
//            System.out.println("Finished");
//        };
//        Thread thread = new Thread(task);
//        thread.start();
//        thread.interrupt();
        Object lock = new Object();
        synchronized (lock) {
            //
            lock.notify();
            lock.wait();
            //
        }
        synchronized (lock) {
            lock.wait();
            lock.notify();
        }

    }
}
