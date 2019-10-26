package com.xulk.mashibing.countDownLatch;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by xulinkai on 2019/7/22.
 * 实现一个容器 提供add和size方法，
 * 两个线程，一个线程往里面添加添加10个元素，另外一个线程监控容器，达到五个元素的时候，结束线程
 * 添加volatile关键字，变量让两个线程可见（但是依然存在问题：while true监听很浪费时间，break的时候没有同步，
 * break的时候可能其他线程又会进来，导致size>5）
 * 此时可以使用wait(会释放锁)和notify（不会释放锁）  ，线程2不用去监听，当list的size是5的时候，去通知线程2
 * 此时依然不能实现效果，因为notify不会释放锁，t2依然无法获得锁
 * 可以符合条件时释放锁，执行完之后，重新唤醒，继续执行
 */
public class MyContainer04 {

    volatile List<Object> list = new ArrayList<>();

    public void add(String string) {
        list.add(string);
    }

    public int size() {
        return list.size();
    }

    public static void main(String[] args) {
        MyContainer04 my = new MyContainer04();
        final Object object = new Object();

        new Thread(() -> {
            synchronized (object){
                for (int i = 0; i < 10; i++) {
                    my.add(i + "string");
                    System.out.println("adddd " + i);
                    if(my.size() ==5){
                        //不会释放锁
                        object.notify();
                        try {
                            object.wait();//释放当前锁
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "t1").start();

        new Thread(() -> {
            synchronized (object){
                if(my.size()!= 5){
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("t2 结束");
                //通知t1继续执行
                object.notify();
            }
        }, "t2").start();


    }
}
