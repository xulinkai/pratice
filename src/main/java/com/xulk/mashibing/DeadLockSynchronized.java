package com.xulk.mashibing;

import java.util.concurrent.TimeUnit;

/**
 * Created by xulinkai on 2019/7/25.
 * synchronized 类型的死锁
 * 两者都持有对方需要的锁，且不释放
 */
public class DeadLockSynchronized {

    private final  String str1 = "str1";

    private final  String str2 = "str2";

    public void methodA(){
        System.out.println("str1方法运行！");
        synchronized (str1){
            System.out.println("str1方法拿到了str1的锁");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (str2){
                System.out.println("str1方法 拿到了str2的锁");
            }
        }
    }

    public void methodB(){
        System.out.println("str2方法运行");
        synchronized (str2){
            System.out.println("str2方法拿到了str2的锁");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (str1){
                System.out.println("str2拿刀了str1的锁");
            }
        }
    }

    public static void main(String[] args) {
        DeadLockSynchronized deadLockSynchronized = new DeadLockSynchronized();
        new Thread(()->{
            deadLockSynchronized.methodA();
        }).start();

        new Thread(()->{
            deadLockSynchronized.methodB();
        }).start();
    }
}
