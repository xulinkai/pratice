package com.xulk.mashibing.jiaGouShi.gaoBingFa.cyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @description:  循环栅栏 等待人数满了 推倒栅栏 人过去
 *                栅栏重新起来  等待人数满了 推倒栅栏 人过去
 * @author:
 * @create: 2020-02-03 15:17
 **/
public class T01_CyclicBarrier {

    public static void main(String[] args) {
        //CyclicBarrier cyclicBarrie = new CyclicBarrier(20, ()->{System.out.println("满人 发车"); });
        CyclicBarrier cyclicBarrier = new CyclicBarrier(20, new Runnable() {
            @Override
            public void run() {
                System.out.println("满人， 发车");
            }
        });

        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
