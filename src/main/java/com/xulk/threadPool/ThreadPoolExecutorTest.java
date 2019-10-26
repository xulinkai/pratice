package com.xulk.threadPool;


import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by xulinkai on 2019/7/21.
 */
public class ThreadPoolExecutorTest {

    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1,2,3, TimeUnit.SECONDS,new LinkedBlockingDeque<>(3));
        executor.execute(new MyThread());
        executor.execute(new MyThread());
        executor.execute(new MyThread());
        executor.execute(new MyThread());
        executor.execute(new MyThread());
        executor.execute(new MyThread());//会报错，达到了最大线程数，且阻塞队列已满
        executor.shutdown();
    }
}

class MyThread implements  Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
