package com.xulk.mashibing;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by xulinkai on 2019/7/25.
 * lock类型的死锁
 * lock因为异常或其他原因没有能够及时释放 导致死锁
 */
public class DeadLockLock {

    private Lock lock = new ReentrantLock();

    public void methodA(){
        lock.lock();
        try {
            TimeUnit.SECONDS.sleep(1);
            System.out.println("methodA方法运行了");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
       int i = 1/0;
        lock.unlock();
    }

    public void methodB(){
        lock.lock();
        try {
            TimeUnit.SECONDS.sleep(1);
            System.out.println("methodB方法运行了");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.unlock();
    }

    public static void main(String[] args) {
        DeadLockLock deadLockLock = new DeadLockLock();
        new Thread(()->{
            deadLockLock.methodA();
        }).start();

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(()->{
            deadLockLock.methodB();
        }).start();
    }
}
