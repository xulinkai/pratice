package com.xulk.mashibing.jiaGouShi.gaoBingFa.countDownLatch;

import java.util.concurrent.CountDownLatch;
import java.util.stream.Stream;

public class CountDownLatch_01 {

    public static void method() throws InterruptedException {
        Thread[] threads = new Thread[100];
        CountDownLatch countDownLatch = new CountDownLatch(threads.length);
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(()->{
                System.out.println("当前线程：");
                countDownLatch.countDown();
            });
        }

        Stream.of(threads).forEach(o->{
            o.start();
        });
        //当前线程会阻塞在这里
        countDownLatch.await();
        System.out.println("method end ..................");
    }

    public static void main(String[] args) throws InterruptedException {
        method();

    }
}
