package com.xulk.mashibing.queue;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by xulinkai on 2019/7/31.
 * 写时复制容器 copy on write
 * 多线程环境下，写时效率低，读时效率高
 * 适合写少读多的环境
 * 读的时候不用加锁，写的时候，会把原来的list复制一份，追加到后面或从里面减去
 */
public class CopyOnWriteList_01 {

    public static void main(String[] args) {
        List<String> list =
                //new ArrayList<>();//这个可能会出现并发问题
                //new Vector<>();
                new CopyOnWriteArrayList<>();
        Random random = new Random();
        Thread[] threads = new Thread[100];
        for (int i = 0; i <threads.length ; i++) {

            Runnable task = new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j <1000 ; j++) {
                        list.add("a"+random.nextInt(1000));
                    }
                }
            };
            threads[i] = new Thread(task);
        }
        runAndCoputeTime(threads);
        System.out.println(list.size());

    }

    static void runAndCoputeTime(Thread[] ths){
        long start = System.currentTimeMillis();
        Arrays.asList(ths).forEach(thread->thread.start());
        Arrays.asList(ths).forEach(thread->{
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        long end = System.currentTimeMillis();
        System.out.println(end-start);

    }
}
