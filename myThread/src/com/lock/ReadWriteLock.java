package com.lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁测试类:
 * 可以同时度
 */
public class ReadWriteLock implements Runnable {


    private ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();

    @Override
    public void run() {
        this.test1();
    }

    /**
     * 可以同时读
     * 情况（1）线程a占有读锁，那么写锁线程需要等待所有读锁释放
     * （2）线程a占有写锁，其他所有读写线程均需要等待获取线程:
     *  可重入锁:并不是读写锁这种理解，而是说锁只是绑定线程，而与调用方法无关，当当前线程获取锁时，调用同样需要获取该锁的线程，不需要等待，即可重入
     *  公平锁:按照访问时间顺序
     *  可中断锁:即可以中断等待(synginzed无法做到)
     *  读写锁:可以同时读
     *
     */
    public void test1() {
        reentrantReadWriteLock.readLock().lock();
        try {
            Thread.sleep(2000);
            System.out.println("当前线程名字" + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            reentrantReadWriteLock.readLock().unlock();//释放锁
        }
    }
}
