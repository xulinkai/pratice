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
 * <p>
 * 使用reentrantlock可以进行 尝试锁定 tryLock 这样无法锁定，或者在指定时间内无法锁定，线程可以决定是否继续等待
 * <p>
 * 使用ReentrantLock还可以调用lockInterruptibly方法，可以对线程interrupt方法做出相应
 * 在一个线程等待锁的过程中，可以被打断
 */
public class ReentrantLock04 {


    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Thread t1 = new Thread(() -> {
            try {
                lock.lock();
                System.out.println("t1 start");
                TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
                System.out.println("t1 end");
            } catch (InterruptedException e) {
                System.out.println("t1 interrupted");
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        });
        t1.start();

        Thread t2 = new Thread(() -> {
            try {
                //资源一直被t1占用，t2获取不到，但是不想让t2等待了，
                //lock.lock();  无法得到锁的时候   无法被打断
                lock.lockInterruptibly();// 表示当前线程是可以被打断的 可以对interrupt方法做出响应
                System.out.println("t2 start");
                TimeUnit.SECONDS.sleep(5);
                System.out.println("t2  end");
            } catch (InterruptedException e) {
                System.out.println("t2 interrupted");
            }finally {
                lock.unlock();
            }
        });
        t2.start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.interrupt();//打断线程2的等待
    }
}
