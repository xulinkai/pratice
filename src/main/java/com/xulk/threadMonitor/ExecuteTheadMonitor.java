package com.xulk.threadMonitor;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;

/**
 * Created by xulinkai on 2019/7/25.
 */
public class ExecuteTheadMonitor implements Callable<String> {

    private ExecutorService executor;
    private CountDownLatch countDownLatch;
    private List<Runnable> executeThreads;

    public ExecuteTheadMonitor(ExecutorService executor) {
        this.executor = executor;
        countDownLatch = new CountDownLatch(5);
        executeThreads = Arrays.asList(new ExecuteThread(countDownLatch,"executeThread 1"),
                new ExecuteThread(countDownLatch,"executeThread 2"),
                new ExecuteThread(countDownLatch,"executeThread 3"),
                new ExecuteThread(countDownLatch,"executeThread 4"),
                new ExecuteThread(countDownLatch,"executeThread 5")
                );
    }

    @Override
    public String call() throws Exception {
        System.out.println("execute 开始...........");
        executeThreads.stream().forEach(executeThread->executor.submit(executeThread));
        countDownLatch.await();
        return "EXECUTE_SUCCESS";
    }
}
