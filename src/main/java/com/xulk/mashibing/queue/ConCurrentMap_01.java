package com.xulk.mashibing.queue;

import java.util.*;
import java.util.concurrent.CountDownLatch;

/**
 * Created by xulinkai on 2019/7/29.
 */
public class ConCurrentMap_01 {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        //Map<String, String> map = new ConcurrentHashMap<>();//500   分段锁，16段，不是锁整个map，如果两个值存在了两个段上，就可以同时存取，（并发很大的时候使用）
        //Map<String, String> map = new ConcurrentSkipListMap<>();//高并发并且排序比较适合
        //Map<String, String> map = new Hashtable<>();//700   锁这个map   并发不太高的时候使用
        Random random = new Random();
        Thread[] threads = new Thread[100];
        CountDownLatch countDownLatch = new CountDownLatch(threads.length);
        long start = System.currentTimeMillis();
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 10000; j++) {
                    map.put("a" + random.nextInt(100000), "a" + random.nextInt(100000));
                }
                countDownLatch.countDown();
            });
        }
        Arrays.asList(threads).forEach(thread -> thread.start());
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("end-start"+(end-start));
    }
}
