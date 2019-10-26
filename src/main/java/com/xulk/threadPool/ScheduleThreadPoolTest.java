package com.xulk.threadPool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by xulinkai on 2019/7/21.
 * 周期性执行任务的线程池，按照某种特定的计划执行线程中的任务，有核心线程，也有非核心线程，
 非核心线程的大小为无限大，适用于执行周期性的任务，
 */
public class ScheduleThreadPoolTest {

    public static void main(String[] args) {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(3);
        for (int i = 0; i <100 ; i++) {
            //3s后执行当前线程任务
            executor.schedule(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                }
            },3, TimeUnit.SECONDS);
        }
    }
}
