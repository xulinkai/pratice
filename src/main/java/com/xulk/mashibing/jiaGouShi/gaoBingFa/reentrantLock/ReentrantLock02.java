package com.xulk.mashibing.jiaGouShi.gaoBingFa.reentrantLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by xulinkai on 2019/7/23.
 * ReentrantLock用于替代syncthronized
 * 本例由于m1锁定this，只有m1执行完毕的时候，m2才会执行，
 * lock.lock();相当于synchronized(this),需要注意的是，必须要手动释放锁
 * 使用synchronized锁的时候遇到异常，jvm会释放当前锁，但是lock必须手动释放锁，通常在finally里面释放
 */
public class ReentrantLock02 {

    Lock lock = new ReentrantLock();

     void  m1(){
         lock.lock();
         try {
             for (int i = 0; i <10 ; i++) {
                 TimeUnit.SECONDS.sleep(1);
                 System.out.println(i);
                 //测试可重入
                 if(i == 3){
                     m2();
                 }
             }
         }catch (InterruptedException e){
             e.printStackTrace();
         }finally {
             lock.unlock();
         }
    }

     void m2(){
         lock.lock();
        System.out.println("m2........");
        lock.unlock();
    }

    public static void main(String[] args) {
        ReentrantLock02 reentrantLock01 = new ReentrantLock02();
        new Thread(reentrantLock01::m1).start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(reentrantLock01::m2).start();
    }
}
