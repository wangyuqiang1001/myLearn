package com.wang;

import java.util.concurrent.ThreadPoolExecutor;

public class LockTest {


    /**
     * 加锁方式:(1)给代码块加锁
     * （2）给对象加锁/给方法枷锁（以上三种方式都作用于同一对象）
     * （3）给类枷锁，给静态方法加锁，（作用于该类的所有对象）(解释起来就是静态方法作用和对象无关，是直接使用类调用的的)
     * @param args
     */
    public static void main(String[] args) {
        ThreadTestLock t1 = new ThreadTestLock();
        ThreadTestLock t2 = new ThreadTestLock();
        new Thread(t1).start();
        new Thread(t2).start();
    }
}
