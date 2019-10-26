package com.xulk.mashibing.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by xulinkai on 2019/8/7.
 * execute方法相当于往里面放任务，放了六个任务，
 * 正常关闭，等所有任务执行完毕  service.shutdown();
 * service.isTerminated()  是不是执行完了
 */
public class ThreadPool_test {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(5);
        //execute方法相当于往里面放任务，放了六个任务，
        for (int i = 0; i <6 ; i++) {
            service.execute(()->{
                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
            });
        }
        System.out.println(service);
        //正常关闭，等所有任务执行完毕
        service.shutdown();
        System.out.println(service.isTerminated());
        System.out.println(service.isShutdown());
        System.out.println(service);
        TimeUnit.SECONDS.sleep(5);
        System.out.println(service.isTerminated());
        System.out.println(service.isShutdown());
        System.out.println(service);

    }
}
