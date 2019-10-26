package com.xulk.threadMonitor;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.FutureTask;

/**
 * Created by xulinkai on 2019/7/25.
 */
public class ThreadApplication implements  Runnable {

    private ExecutorService executor;
    private InitThreadMonitor initThreadMonitor;
    private ExecuteTheadMonitor executeTheadMonitor;

    public ThreadApplication(ExecutorService executor) {
        this.executor = executor;
        initThreadMonitor = new InitThreadMonitor(executor);
        executeTheadMonitor = new ExecuteTheadMonitor(executor);
    }


    @Override
    public void run() {
        System.out.println("应用程序开始...........");
        try {
            FutureTask<String> futureTask = new FutureTask<String>(initThreadMonitor);
            executor.submit(futureTask);
            if("INIT_SUCCESS".equals(futureTask.get())){
                FutureTask<String> executeFatureTask = new FutureTask<String>(executeTheadMonitor);
                executor.submit(executeFatureTask);
                if("EXECUTE_SUCCESS".equals(executeFatureTask.get())){
                    executor.shutdown();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("应用程序结束...........");

    }


}
