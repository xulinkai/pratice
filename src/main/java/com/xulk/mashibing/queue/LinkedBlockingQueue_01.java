package com.xulk.mashibing.queue;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/**
 * Created by xulinkai on 2019/7/31.
 * LinkedBlockingDeque  阻塞式队列   无界队列
 * put  如果满了就会等待， take 如果空了 就会等待
 */
public class LinkedBlockingQueue_01 {

    static BlockingQueue<String> blockingQueue = new LinkedBlockingDeque<>();

    static Random random = new Random();

    public static void main(String[] args) {

        new Thread(()->{
            for (int i = 0; i <100 ; i++) {
                try {
                    blockingQueue.put("a"+i);//put  如果满了就会等待， take 如果空了 就会等待
                    TimeUnit.MILLISECONDS.sleep(random.nextInt(1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        },"p1").start();

        for (int i = 0; i <5 ; i++) {
            new Thread(()->{
                for(;;){
                    try {
                        System.out.println(Thread.currentThread().getName()+" take-"+blockingQueue.take());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }

            },"c"+i).start();
        }
    }
}
