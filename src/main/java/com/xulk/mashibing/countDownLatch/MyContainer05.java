package com.xulk.mashibing.countDownLatch;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
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
 * 多次使用wait notify比较麻烦，可以使用CountDownLatch 门栓 达到效果 且不涉及锁定
 *使用await和countDown代替wait和notify，
 *
 */
public class MyContainer05 {

    volatile List<Object> list = new ArrayList<>();

    public void add(String string) {
        list.add(string);
    }

    public int size() {
        return list.size();
    }

    public static void main(String[] args) {
        MyContainer05 my = new MyContainer05();
        //初始值为1，没调用一次countDown就会减1，为0的时候，门栓会打开，
        CountDownLatch countDownLatch = new CountDownLatch(1);

        new Thread(() -> {
                for (int i = 0; i < 10; i++) {
                    my.add(i + "string");
                    System.out.println("adddd " + i);
                    if(my.size() ==5){
                        //打开门栓，让t2得以执行
                        countDownLatch.countDown();
                    }
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        }, "t1").start();

        new Thread(() -> {
                if(my.size()!= 5){
                    try {
                        //门栓等待，不需要锁定对象
                        countDownLatch.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("t2 结束");
                //通知t1继续执行
        }, "t2").start();


    }
}
