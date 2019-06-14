package com.wang;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 多线程总结
 */
public class MultiThreadTest {


    /**
     * 使用池来管理线程中的任务
     */
    public static  void ThreadPoolCreate1() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 50; i++) {
            int index = i;
            executorService.execute(new Test(i));
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }


    public static void main(String[] args) {
   // MultiThreadTest.ThreadPoolCreate1();
        System.out.println("主线程执行之前:");
        Test test = new Test(1);
        test.start();
        System.out.println("主线程执行之后");
    }

}
