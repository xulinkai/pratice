package com.xulk.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by xulinkai on 2019/7/21.
 * 可缓存的线程池，该线程池中没有核心线程，非核心的最大线程数量为Integer.max_value；就是无限大，
 当有需要时，创建线程来执行任务，没有需要时，回收线程，适用于用时少、任务量大的情况，
 */
public class CacheTheradPoolTest {

    public static void main(String[] args) {
        //可缓存线程池
        ExecutorService executor = Executors.newCachedThreadPool();
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
