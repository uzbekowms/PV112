package org.example.service;

import lombok.Synchronized;

public class UserService {

    private final Object readLock = new Object();
    private final Object writeLock = new Object();

    @Synchronized("readLock")
    public void closeThisService() {
        System.out.println("Bye");
    }

    @Synchronized("writeLock")
    public void test() {
        System.out.println("Sync block");
    }

    @Synchronized
    public void anotherBlock(){
        System.out.println("Hello");
    }
}
