package com.xulk;

/**
 * @description:
 * @author:
 * @create: 2020-01-07 22:44
 **/
public class Main1 {

    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
            Main.method();
        }).start();
        Thread.sleep(1000);
        new Thread(()->{
            Main main = new Main();
            main.method1();
        }).start();
    }
}
