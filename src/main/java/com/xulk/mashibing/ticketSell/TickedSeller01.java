package com.xulk.mashibing.ticketSell;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xulinkai on 2019/7/29.
 * 有N张火车票，每张都有一个编号，同时有是个窗口对外售票，请写一个模拟程序
 */
public class TickedSeller01 {

    static List<String> tickets = new ArrayList<>();

    static {
        for (int i = 0; i <10000 ; i++) {
            tickets.add("票号："+i);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i <10 ; i++) {
            new Thread(()->{
                while (tickets.size()>0){
                    System.out.println("销售了....."+tickets.remove(0));
                }
            }).start();
        }
    }
}
