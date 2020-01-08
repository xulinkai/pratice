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
 *
 *使用reentrantlock可以进行 尝试锁定 tryLock 这样无法锁定，或者在指定时间内无法锁定，线程可以决定是否继续等待
 */
public class ReentrantLock03 {

    Lock lock = new ReentrantLock();

     void  m1(){
         lock.lock();
         try {
             for (int i = 0; i <15 ; i++) {
                 TimeUnit.SECONDS.sleep(1);
                 System.out.println(i);
             }
         }catch (InterruptedException e){
             e.printStackTrace();
         }finally {
             lock.unlock();
         }
    }

    /**
     * 使用tryLock可以进行尝试锁定，不管锁定与否，方法都将继续进行
     * 可以根据tryLock的返回值来判定是否锁定
     * 也可以指定tryLock的时间，由于tryLock(time)抛出异常，所以要注意unLock的处理，必须放到finally里面
     */
     void m2(){
         boolean locked = lock.tryLock();
         if(locked){
             System.out.println("m2........");
             lock.unlock();
         }
         /*boolean locked = false;
         try {
             locked = lock.tryLock(5,TimeUnit.SECONDS);  锁等5s，看是否能够拿到锁
             System.out.println("m2........locked");
         } catch (InterruptedException e) {
             e.printStackTrace();
         }finally {
             if(locked){
                 lock.unlock();
             }
         }*/
     }

    public static void main(String[] args) {
        ReentrantLock03 reentrantLock01 = new ReentrantLock03();
        new Thread(reentrantLock01::m1).start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(reentrantLock01::m2).start();
    }
}
