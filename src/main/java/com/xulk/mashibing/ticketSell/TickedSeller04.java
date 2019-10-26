package com.xulk.mashibing.ticketSell;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.TimeUnit;

/**
 * Created by xulinkai on 2019/7/29.
 * 有N张火车票，每张都有一个编号，同时有是个窗口对外售票，请写一个模拟程序
 */
public class TickedSeller04 {

    /**
     * 链表实现的队列，且支持多线程
     */
    static Queue<String> tickets = new ConcurrentLinkedDeque<>();

    static {
        for (int i = 0; i < 10000; i++) {
            tickets.add("票号：" + i);
        }
    }


    public static void main(String[] args) {
        TickedSeller04 tickedSeller02 = new TickedSeller04();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                while (true) {
                    String s = tickets.poll();
                    if (s == null) {
                        break;
                    }
                    System.out.println("销售了....." + s);
                }

            }).start();
        }
    }
}
