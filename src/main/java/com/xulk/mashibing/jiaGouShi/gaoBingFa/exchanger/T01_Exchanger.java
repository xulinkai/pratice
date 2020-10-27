package com.xulk.mashibing.jiaGouShi.gaoBingFa.exchanger;

import java.util.concurrent.Exchanger;

/**
 * @description:  线程之间通信 交换数据   仅指两个线程之间的数据交换
 * @create: 2020-02-03 16:31
 **/
public class T01_Exchanger {

    static Exchanger<String> exchanger = new Exchanger<>();

    public static void main(String[] args) {
        new Thread(() -> {
            String s = "T1";
            try {
                s = exchanger.exchange(s);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " " + s);

        }, "t1").start();

        new Thread(() -> {
            String s = "T2";
            try {
                s = exchanger.exchange(s);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " " + s);

        }, "t2").start();

    }
}
