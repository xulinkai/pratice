package com.xulk.threadMonitor;

import java.util.concurrent.CountDownLatch;

/**
 * Created by xulinkai on 2019/7/25.
 */
public class InitThread implements Runnable {

    private CountDownLatch countDownLatch;
    private String name;

    public InitThread(CountDownLatch countDownLatch, String name) {
        this.countDownLatch = countDownLatch;
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name+"数据初始化................");
        countDownLatch.countDown();
        System.out.println(name+"数据初始化结束...............");
    }


}
