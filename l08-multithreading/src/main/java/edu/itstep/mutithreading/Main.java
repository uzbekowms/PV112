package edu.itstep.mutithreading;

public class Main {

    /*
     * Thread States
     * New
     * Runnable
     * Blocked
     * Terminated
     * Waiting
     *
     * Process -
     * */
    public static void main(String[] args) throws InterruptedException {
        Thread queue1 = new PeopleQueue("Ann", "Petro", "John", "Doe", "Masha");
        Thread queue2 = new PeopleQueue("Mary", "Peter", "Alice", "Vasil", "Vlad");

        System.out.println(Thread.currentThread().getName() + " Start");
        queue1.start();
        queue2.start();
//        while (true){
//            System.exit(0);
//            Runtime.getRuntime().exit(0);
//        }
        //jvisualvm --openid 16972
//        System.out.println(Thread.currentThread().getName() + " End");
    }
}

class PeopleQueue extends Thread {
    private String[] names;

    public PeopleQueue(String... names) {
        this.names = names;
    }

    @Override
    public void run() {
        for (int i = 0; i < names.length; i++) {
            System.out.println(Thread.currentThread().getName() + " Обробили: " + names[i]);
            try {
                sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}


