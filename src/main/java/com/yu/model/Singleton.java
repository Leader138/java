package com.yu.model;

/**
 * @program: java
 * @description: 单例测试
 * @author: yulongguang
 * @create: 2018-03-08 12:35
 **/
public class Singleton {
    //第一种形式
    private Singleton() {
    }

    private static Singleton instance = new Singleton();

    public static Singleton getInstance() {
        return instance;
    }

    public static void main(String[] args) {
//        Singleton singleton = Singleton.getInstance();
        Singleton singleton=Singleton.getSingleton();
        System.out.println(singleton);
    }
    //第二种形式同步
    private static Singleton singleton = null;

    private static synchronized Singleton getSingleton() {
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }


}
