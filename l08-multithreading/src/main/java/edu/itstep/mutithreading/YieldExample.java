package edu.itstep.mutithreading;

import java.lang.ref.WeakReference;

public class YieldExample {
    public static void main(String[] args) {
//        Thread.yield();
        gc();
    }

    public static void gc() {
        Object obj = new Object();
        WeakReference<Object> ref = new WeakReference<>(obj);
        obj = null;
        while(ref.get() != null) {
            System.out.println("Not collected");
            System.gc();
        }
    }
}
