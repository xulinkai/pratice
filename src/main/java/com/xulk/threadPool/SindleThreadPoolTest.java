package com.xulk.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by xulinkai on 2019/7/21.
 * 只有一条线程来执行任务，适用于有顺序的任务的应用场景，
 * 单例线程池
 */
public class SindleThreadPoolTest {

    public static void main(String[] args) {
        //可缓存线程池
        ExecutorService executor = Executors.newSingleThreadExecutor();
        for (int i = 0; i <100 ; i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                }
            });
        }
    }
}
