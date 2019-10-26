package com.xulk.threadPool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/**
 * Created by xulinkai on 2019/7/21.
 */
public class BlockQueueTest {

    public static void main(String[] args) throws Exception{
        /*  会报阻塞队列满了的错误
        BlockingQueue<String> blockingQueue = new LinkedBlockingDeque<>(2);
        blockingQueue.add("today");
        blockingQueue.add("tomorrow");
        blockingQueue.add("week");*/

        //阻塞队列
        BlockingQueue<String> blockingQueue = new LinkedBlockingDeque<>(2);
        blockingQueue.offer("today");
        blockingQueue.offer("week");
        //不会报错，放不进去， 等待3s，放不进去的时候将会取消操作
        blockingQueue.offer("tommorrow", 3, TimeUnit.SECONDS);
        System.out.println(blockingQueue.poll());//today
        System.out.println(blockingQueue.poll());//week
        System.out.println(blockingQueue.poll());//null

    }
}
