package com.xulk.mashibing.queue;

import java.util.concurrent.LinkedTransferQueue;

/**
 * Created by xulinkai on 2019/8/5.
 * LinkedTransferQueue  消费者先起来，生产者有了东西直接扔给消费者
 * 若是生产者先跑起来的话，会出现找不到消费者的情况，会阻塞  只有transfer方法会阻塞
 */
public class TransferQueue_test {

    public static void main(String[] args) throws InterruptedException {
        LinkedTransferQueue<String> linkedTransferQueue = new LinkedTransferQueue<>();
        new Thread(()->{
            try {
                System.out.println(linkedTransferQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        linkedTransferQueue.transfer("aaa");
//        linkedTransferQueue.put("ddd");
        /*new Thread(()->{
            try {
                System.out.println(linkedTransferQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();*/

    }
}
