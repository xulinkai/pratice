package com.xulk.mashibing.jiaGouShi.gaoBingFa.semaphore;

import java.util.concurrent.Semaphore;

/**
 * @description:  信号量
 * @author:
 * @create: 2020-02-03 16:18
 **/
public class T01_Semaphore {

    public static void main(String[] args) {


        //允许一个（permits）线程同时执行
        /*
         * 为 1 的时候，T1执行完之后  T2执行，
         * 为 2 的时候，T1、T2交替执行
         */
        Semaphore semaphore = new Semaphore(1);
        new Thread(()->{
            try {
                semaphore.acquire();
                System.out.println("T1 running .........");
                Thread.sleep(100);
                System.out.println("T1 running...........");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                semaphore.release();
            }
        }).start();

        new Thread(()->{
            try {
                semaphore.acquire();
                System.out.println("T2 running .........");
                Thread.sleep(100);
                System.out.println("T2 running...........");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                semaphore.release();
            }
        }).start();
    }
}
