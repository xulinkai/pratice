package com.xulk.mashibing.queue;

import java.util.concurrent.BlockingQueue;

/**
 * Created by xulinkai on 2019/7/31.
 * ArrayBlockingQueue  有界队列
 */
public class ArrayBlockingQueue {

    static BlockingQueue<String> blockingQueue = new java.util.concurrent.ArrayBlockingQueue<String>(10);


    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i <10 ; i++) {
            blockingQueue.put("a"+i);
        }
        //blockingQueue.put("b");//会阻塞
        blockingQueue.add("c");//会报异常
//        blockingQueue.offer("e");//不会报异常，但是加不进去，返回false
//        blockingQueue.offer("c",1, TimeUnit.SECONDS);  1秒钟之后加不进去，放弃加入
        System.out.println(blockingQueue);


    }
}
