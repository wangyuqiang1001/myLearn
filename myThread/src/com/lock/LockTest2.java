package com.lock;

public class LockTest2 {

    public static void main(String[] args) {
        ReadWriteLock readLock = new ReadWriteLock();
        new Thread(readLock).start();
        new Thread(readLock).start();
    }
}
