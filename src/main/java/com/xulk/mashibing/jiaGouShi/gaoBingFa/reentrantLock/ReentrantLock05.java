package com.xulk.mashibing.jiaGouShi.gaoBingFa.reentrantLock;

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
 * <p>
 * 使用ReentrantLock还可以指定为公平锁  谁等的时间长，让谁得到这把锁，
 */
public class ReentrantLock05 extends Thread {

    private static ReentrantLock reentrantLock = new ReentrantLock(true);//参数为true的时候表示为公平锁，请对比输出结果


    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            reentrantLock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + "_" + i + "获得锁");
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        ReentrantLock05 reentrantLock05 = new ReentrantLock05();
        Thread a = new Thread(reentrantLock05);
        Thread b = new Thread(reentrantLock05);
        Thread c = new Thread(reentrantLock05);
        a.start();
        b.start();
        c.start();

    }
}
