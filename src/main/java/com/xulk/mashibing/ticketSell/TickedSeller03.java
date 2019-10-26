package com.xulk.mashibing.ticketSell;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.TimeUnit;

/**
 * Created by xulinkai on 2019/7/29.
 * 有N张火车票，每张都有一个编号，同时有是个窗口对外售票，请写一个模拟程序
 */
public class TickedSeller03 {

    static List<String> tickets = new ArrayList<>();

    static {
        for (int i = 0; i < 10000; i++) {
            tickets.add("票号：" + i);
        }
    }


    public static void main(String[] args) {
        TickedSeller03 tickedSeller02 = new TickedSeller03();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                while (true) {
                    synchronized (tickets) {
                        if (tickets.size() <= 0) {
                            break;
                        }
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("销售了....." + tickets.remove(0));

                    }
                }

            }).start();
        }
    }
}
