package edu.itstep.mutithreading;

import java.util.concurrent.*;

public class ExecutorExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        ExecutorService executor1 = Executors.newSingleThreadExecutor();
////        ExecutorService executor2 = Executors.newFixedThreadPool(10);
////        ExecutorService executor3 = Executors.newScheduledThreadPool(10);
//        Future future = executor1.submit(() -> {
//            String threadName = Thread.currentThread().getName();
//
////            try {
////                Thread.sleep(5000);
////            } catch (InterruptedException e) {
////                throw new RuntimeException(e);
////            }
//            System.out.println("Hello from " + threadName);
//        });
//
//        executor1.execute(() -> {
//            String threadName = Thread.currentThread().getName();
//            System.out.println("Hello again from " + threadName);
//        });

//        try {
//            if(future.get() == null){
//                System.out.println("Success");
//            }
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        } catch (ExecutionException e) {
//            throw new RuntimeException(e);
//        }
//
//        executor1.shutdown();

        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(1);
        MyCallable myCallable = new MyCallable();
        Future<Integer> result = executor.submit(myCallable);
        System.out.println("Wainting");
        System.out.println("Result is " + result.get());
        System.out.println(result.isDone());
        executor.shutdown();
    }
}


class MyCallable implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        Thread.sleep(5000);
        return 10;
    }
}