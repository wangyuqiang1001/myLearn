package com.lock;

import java.util.TreeMap;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 其实这个类代表的是可重入锁:
 */

public class ReadLock implements Runnable {

    private ReentrantLock reentrantLock = new ReentrantLock();

    @Override
    public void run() {
//        this.testLock();
//        this.tesLock();
        try {
            this.testLockInternet();
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName()+"中断了等待锁");
            //e.printStackTrace();
        }
    }


    /**
     * 普通获取锁的方式
     */
    public void testLock() {

        reentrantLock.lock();
        try {
            System.out.println(Thread.currentThread().getName());//当前锁名字
            Thread.sleep(2000);
        } catch (Exception e) {

        } finally {
            System.out.println(Thread.currentThread().getName() + "释放了锁");
            reentrantLock.unlock();//释放锁
        }
    }


    /**
     * 尝试获取锁
     * testLock尝试获取锁，如果没有获取到，并不会等待，而是就此释放资源
     */
    public void tesLock() {
        if (reentrantLock.tryLock()) {
            try {
                System.out.println("当前线程尝试获取了锁"+Thread.currentThread().getName());
                Thread.sleep(2000);
            }catch (Exception e){

            }finally {
                System.out.println(Thread.currentThread().getName()+"释放了锁");
                reentrantLock.unlock();
            }
        } else {
            System.out.println("获取锁失败，当前线程"+Thread.currentThread().getName());
        }
    }

    /**
     * 在获取不到锁时会中断获取锁
     */
    public  void testLockInternet() throws InterruptedException {
        reentrantLock.lockInterruptibly();
        try{
            System.out.println("当前线程获取了锁,"+Thread.currentThread().getName());
            Thread.sleep(5000);
        }catch (Exception e){

        }finally {
            System.out.println("当前线程释放了锁"+Thread.currentThread().getName());
            reentrantLock.unlock();
        }
    }
}
