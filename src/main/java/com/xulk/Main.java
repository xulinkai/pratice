package com.xulk;

/**
 * @description:
 * @author:
 * @create: 2020-01-07 22:42
 **/
public class Main {

    public static synchronized void method(){
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("cccccccccccccccccc");
    }

    public synchronized void  method1(){
        System.out.println("aaaaaaaaaaaaaaaaa");
    }
}
