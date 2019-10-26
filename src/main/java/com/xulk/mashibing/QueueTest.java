package com.xulk.mashibing;

import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * Created by xulinkai on 2019/7/21.
 */
public class QueueTest {

    public static void main(String[] args) {
        //无边界队列，没有长度限制   非阻塞队列
        ConcurrentLinkedDeque<String> queue = new ConcurrentLinkedDeque<>();
        //入队操作
        queue.add("xulinkai");
        queue.add("today");
        queue.add("week");
        System.out.println(queue.poll());//xulinkai
        System.out.println(queue.poll());//today
        System.out.println(queue.poll());//week
        /*System.out.println(queue.peek());//输出但是在队列中不移除元素*/
        System.out.println(queue.poll());//null

    }
}
