package com.xulk.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by xulinkai on 2019/7/21.
 * 定长线程池，有核心线程，没有非核心线程，即核心线程数量即为最大线程池的数量，
 * 无界队列
 */
public class FixThreadPoolTest {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);
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
