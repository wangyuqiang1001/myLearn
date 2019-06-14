package com.wang;

public class ThreadTestLock implements  Runnable{


    /**
     * 锁静态方法，作用于该类的所有对象
     */
    public static synchronized  void  get2(){
        System.out.println(Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 锁非静态方法，作用于单个对象
     */
    public  synchronized void   get1(){
        System.out.println(Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    /**
     * 锁静态代码块， 应该是作用于同一个对象
     */
    public void lockKuai(){

        synchronized (this){
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
    @Override
    public void run() {
       // this.get1();

      // ThreadTestLock.get2();

    this.lockKuai();
    }
}
