package com.xulk.mashibing.queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * Created by xulinkai on 2019/8/5.
 * SynchronousQueue  容量为0的queue
 * 需要立刻消费掉生产者生产的东西
 */
public class SynchronousQueue_test {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> blockingQueue = new SynchronousQueue<>();
        new Thread(()->{
            try {
                System.out.println(blockingQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
//        blockingQueue.add("xulinkai");
        blockingQueue.put("xu");//阻塞等待消费者消费
        System.out.println(blockingQueue.size());

    }
}
