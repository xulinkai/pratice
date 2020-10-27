package com.xulk.mashibing.jiaGouShi.gaoBingFa.reentrantLock;

import java.util.concurrent.TimeUnit;

/**
 * Created by xulinkai on 2019/7/23.
 * ReentrantLock用于替代syncthronized
 * 本例由于m1锁定this，只有m1执行完毕的时候，m2才会执行，
 *
 */
public class ReentrantLock01 {

    synchronized void  m1(){
        for (int i = 0; i <10 ; i++) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i);
            //测试可重入锁
            if(i == 2){
                m2();
            }
        }
    }

    synchronized void m2(){
        System.out.println("m2........");
    }

    public static void main(String[] args) {
        ReentrantLock01 reentrantLock01 = new ReentrantLock01();
        new Thread(reentrantLock01::m1).start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(reentrantLock01::m2).start();


    }
}
