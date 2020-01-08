package com.xulk.mashibing.jiaGouShi.gaoBingFa.countDownLatch;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by xulinkai on 2019/7/22.
 * 实现一个容器 提供add和size方法，
 * 两个线程，一个线程往里面添加添加10个元素，另外一个线程监控容器，达到五个元素的时候，结束线程
 * 添加volatile关键字，变量让两个线程可见（但是依然存在问题：while true监听很浪费时间，break的时候没有同步，
 * break的时候可能其他线程又会进来，导致size>5）
 */
public class MyContainer02 {

    volatile List<String> list = new ArrayList<>();

    public void add(String string) {
        list.add(string);
    }

    public int size() {
        return list.size();
    }

    public static void main(String[] args) {
        MyContainer02 my = new MyContainer02();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                my.add(i + "string");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("addd " + i);
            }
        }, "t1").start();

        new Thread(() -> {
            while (true) {
                if (my.size() == 5) {
                    break;
                }
            }
            System.out.println("t2 结束");
        }, "t2").start();
    }
}
