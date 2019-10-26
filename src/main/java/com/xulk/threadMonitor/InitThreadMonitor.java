package com.xulk.threadMonitor;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;

/**
 * Created by xulinkai on 2019/7/25.
 */
public class InitThreadMonitor implements Callable<String> {

    private ExecutorService executor;
    private List<Runnable> initThreads;
    private CountDownLatch countDownLatch;

    public InitThreadMonitor(ExecutorService executor) {
        this.executor = executor;
        countDownLatch = new CountDownLatch(3);
        initThreads = Arrays.asList(new InitThread(countDownLatch,"initThread A"),
                new InitThread(countDownLatch,"initThread B"),
                new InitThread(countDownLatch,"initThread C"));
    }

    @Override
    public String call() throws Exception {
        System.out.println("初始化开始............");
        initThreads.stream().forEach(initThread->executor.submit(initThread));
        countDownLatch.await();
        System.out.println("初始化完成");
        return "INIT_SUCCESS";
    }

}
