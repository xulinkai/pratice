package com.xulk.mashibing.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by xulinkai on 2019/8/8.
 * 保证任务顺序执行
 */
public class SingleThreadPool_test {

    public static void main(String[] args) {

        ExecutorService service = Executors.newSingleThreadExecutor();
        for (int i = 0; i <5 ; i++) {
            final  int j = i;
            service.execute(()->{
                System.out.println(Thread.currentThread().getName()+j);
            });
        }
    }
}
