package com.xulk.mashibing.jiaGouShi.gaoBingFa.ReadWriteLock;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @description:  读写锁
 *                加读锁的时候其它线程也可以进行读操作  提高效率
 *                加写锁的时候其它线程不能进行写操作
 * @author:
 * @create: 2020-02-03 15:52
 **/
public class T01_ReadWriteLock {


    static Lock lock = new ReentrantLock();
    private static int value;

    static ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    static Lock readLock = readWriteLock.readLock();
    static Lock writeLock = readWriteLock.writeLock();

    public static void read(Lock lock){
        try {
            lock.lock();
            Thread.sleep(1000);
            System.out.println("read over....");
            //模拟读取操作
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public static void write(Lock lock, int v){
        try {
            lock.lock();
            Thread.sleep(1000);
            value = v;
            System.out.println("write over....");
            //模拟写操作
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        /**
        * 使用lock的时候，是互斥锁，排它锁，读的时候也要按顺序来读
        */
        Runnable readR = ()->read(lock);
        /**
         * 使用readLock的时候，共享锁，其它读的线程可以继续进行读操作
         */
//        Runnable readR = ()->read(readLock);

        Runnable writeR = ()->write(lock, new Random().nextInt());
//        Runnable writeR = ()->write(writeLock, new Random().nextInt());
        for (int i = 0; i < 18; i++) {
            new Thread(readR).start();
        }

        for (int i = 0; i < 2; i++) {
            new Thread(writeR).start();
        }



    }

}
