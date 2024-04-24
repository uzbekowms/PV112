package edu.itstep.mutithreading;

public class ThreadGroupExample {
    public static void main(String[] args) {
//        Thread currentThread = Thread.currentThread();
//        ThreadGroup threadGroup = currentThread.getThreadGroup();
//
//        System.out.println("Thread: " + currentThread.getName());
//        System.out.println("Thread group: " + threadGroup.getName());
//        System.out.println("Parent group: " + threadGroup.getParent().getName());
        Thread th = Thread.currentThread();

        th.setUncaughtExceptionHandler((t, e) -> {
            System.out.println("Exception: '" + e.getMessage() + "' in " + t.getName());
        });
        System.out.println(2 / 0);
    }
}
