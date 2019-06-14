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


//        .lock
//        锁代码块等针对的是对象，对象是唯一的额，而这种是对象里面的局部变量，
//        可以考虑是无状态独享，每个线程都会复制一份;只有设计成全局对象，才能保证锁住
//        即便是两个对象，也可以保证，因为静态变量是被该类的所有对象共享
//        (当为成员变量时，如果是单例，则无法保证，因为两个对象的成员变量不同)
        ReadLock readLock = new ReadLock();
        ReadLock readLock1 = new ReadLock();
        new Thread(readLock).start();
        new Thread(readLock).start();



//        .tryLock   未获取到锁的线程将不会等待，直接释放资源:
//        ReadLock readLock = new ReadLock();
//        new Thread(readLock).start();
//        new Thread(readLock).start();



//        lockIntered当该线程处于等待阻塞时，调用线程叨扰方法会使改方法抛出异常，并中断等待
//
//        ReadLock readLock = new ReadLock();
//        Thread thread1 = new Thread(readLock);
//        Thread thread2 = new Thread((readLock));
//        thread1.start();
//        thread2.start();
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        thread1.interrupt();
//        thread2.interrupt();
    }
}
