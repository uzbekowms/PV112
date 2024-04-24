package edu.itstep.mutithreading;

public class RunnableExample {
    public static void main(String[] args) {
        Runnable task = () -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Hello world from " + Thread.currentThread().getName());
        };
        Thread thread = new Thread(new Task());
        thread.setDaemon(false);
        thread.start();
        System.out.println("End");
    }
}

class Task implements Runnable {

    @Override
    public void run() {
        System.out.println("Hello");
    }
}
