package com.yu.model;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: java
 * @description: 测试线程--火车站买票 多线程同步锁
 * @author: yulongguang
 * @create: 2018-03-08 15:22
 **/
public class TestThread extends Thread {
   private  ExecutorService cachedThreadPool = Executors.newCachedThreadPool();


    public TestThread(String Name) {
        super(Name);
    }

    //定义50张票
    private static int tick = 50;
    //创建一个静态锁,值可以是任意值
    private static Object obj = "aa";

    @Override
    public void run() {
        while (tick > 0) {
            //使用锁，进去拿锁，出来放锁
            synchronized (obj) {
                if (tick > 0) {
                    System.out.println(getName() + "卖出了第" + tick + "张票");
                    tick--;
                } else {
                    System.out.println("票卖完了");
                }
            }
            try {
                sleep(1000);//休息一秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        TestThread testThread = new TestThread("窗口1");
        TestThread testThread1 = new TestThread("窗口2");
        TestThread testThread2 = new TestThread("窗口3");
        TestThread testThread3 = new TestThread("窗口4");
        testThread.start();
        testThread1.start();
        testThread2.start();
        testThread3.start();
    }
}
