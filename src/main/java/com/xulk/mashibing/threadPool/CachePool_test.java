package com.xulk.mashibing.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by xulinkai on 2019/8/8.
 * newCachedThreadPool  来一个任务开启一个线程，再来一个任务看有没有空闲线程，
 * 有，空闲线程直接执行，没有，new一个新的线程继续执行，
 * 再来新的任务，重复上流程，
 * 空闲线程存活时间默认60s，可自定义
 *
 */
public class CachePool_test {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newCachedThreadPool();
        System.out.println(service);
        for (int i = 0; i <2 ; i++) {
            service.execute(()->{
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            System.out.println(Thread.currentThread().getName());
        }
        System.out.println(service);
        TimeUnit.MILLISECONDS.sleep(80000);
        System.out.println(service);
    }
}
