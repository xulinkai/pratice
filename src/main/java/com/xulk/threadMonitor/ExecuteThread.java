package com.xulk.threadMonitor;

import java.util.concurrent.CountDownLatch;

/**
 * Created by xulinkai on 2019/7/25.
 */
public class ExecuteThread implements Runnable {

    private CountDownLatch countDownLatch;
    private String name;

    public ExecuteThread(CountDownLatch countDownLatch, String name) {
        this.countDownLatch = countDownLatch;
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name+"execute开始.........");
        countDownLatch.countDown();
        System.out.println(name+"execute结束..........");
    }
}
