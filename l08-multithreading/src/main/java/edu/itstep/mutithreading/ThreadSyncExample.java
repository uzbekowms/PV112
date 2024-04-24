package edu.itstep.mutithreading;

public class ThreadSyncExample {
    public static int counter = 0;
    public static final Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        int limit = 10000;
        IncThread incThread = new IncThread(limit);
        DecThread decThread = new DecThread(limit);

        incThread.start();
        decThread.start();

        incThread.join();
        decThread.join();

        System.out.println("Counter = " + counter);

        Object object = new Object();
        synchronized (object){
            System.out.println("Hello world");
        }

    }
}

class IncThread extends Thread {

    private int limit;

    public IncThread(int limit) {
        this.limit = limit;
    }

    @Override
    public void run() {
        for (int i = 0; i < limit; i++) {
            synchronized (ThreadSyncExample.lock) {
                ThreadSyncExample.counter++;
            }
        }
    }
}


class DecThread extends Thread {

    private int limit;

    public DecThread(int limit) {
        this.limit = limit;
    }

    @Override
    public void run() {
        for (int i = 0; i < limit; i++) {
            synchronized (ThreadSyncExample.lock) {
                ThreadSyncExample.counter--;
            }
        }
    }
}
