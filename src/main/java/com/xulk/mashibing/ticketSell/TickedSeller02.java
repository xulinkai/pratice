package com.xulk.mashibing.ticketSell;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.TimeUnit;

/**
 * Created by xulinkai on 2019/7/29.
 * 有N张火车票，每张都有一个编号，同时有是个窗口对外售票，请写一个模拟程序
 */
public class TickedSeller02 {

    static Vector<String> tickets = new Vector<>();

    static {
        for (int i = 0; i < 10000; i++) {
            tickets.add("票号：" + i);
        }
    }


    public static void main(String[] args) {
        TickedSeller02 tickedSeller02 = new TickedSeller02();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                //判断和操作分离，  两者之间有可能会被打断，出现卖多、卖重、等情况
                while (tickets.size() > 0) {//size()原子的
                    /*try {
                        TimeUnit.MILLISECONDS.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }*/
                    System.out.println("销售了....." + tickets.remove(0));//remove()原子的
                }
            }).start();
        }
    }
}
