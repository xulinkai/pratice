package com.xulk.mashibing.queue;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * Created by xulinkai on 2019/7/31.
 * 数据可以重复
 * ConcurrentLinkedDeque   ConcurrentLinkedDeque
 */
public class ConcurrentQueue {

    public static void main(String[] args) {
        Queue<String> queue = new ConcurrentLinkedDeque<>();//ConcurrentLinkedDeque
        for (int i = 0; i <10 ; i++) {
            queue.offer("a" + i);
        }
        System.out.println(queue);
        System.out.println(queue.size());
        System.out.println(queue.poll());//a0  拿走一个
        System.out.println(queue.size());//9
        System.out.println(queue.peek());//a1  拿出来，但是不删除
        System.out.println(queue.size());//9
    }
}
