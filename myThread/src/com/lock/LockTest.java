package com.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * java.util.lock锁机制  升级性的lock锁机制
 */
public class LockTest {

    /**
     * 尝试获取锁:
     * 所有获取锁的方式均需要释放:（因为获取锁以后是无法主动释放的，因此需要在finally()语句块中进行锁的释放）
     * lockInternet 获取锁，如果无法获取到，那么会中断阻塞等待
     */
    public void  testLock(){

        //我需要实现相关代码和具体业务
    }

    /**
     * 可重入锁，唯一实现lock接口
     */
    public  void  readLock(){

    }


    public static void main(String[] args) {
        ReadLock readLock = new ReadLock();
       // ReadLock readLock1 = new ReadLock();
        new Thread(readLock).start();//锁代码块等针对的是对象，对象是唯一的额，而这种是对象里面的局部变量，
        //可以考虑是无状态独享，每个线程都会复制一份;只有设计成全局对象，才能保证锁住

        //即便是两个对象，也可以保证，因为静态变量是被该类的所有对象共享的
        Thread thread = new Thread(readLock);
        thread.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread.interrupt();
    }
}
