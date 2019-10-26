package com.xulk.mashibing.countDownLatch;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

/**
 * Created by xulinkai on 2019/7/24.
 * 写一个固定容量同步器，拥有put和get方法，一级getCount方法，
 * 能够支持两个生产者线程以及10个消费者线程的阻塞调用，
 * <p>
 * 使用wait notify和notifyAll来实现
 */
public class Container01<T> {

    final private LinkedList<T> list = new LinkedList<>();
    final private int MAX = 10;
    private int count = 0;

    public synchronized int put(T t) {
        while (list.size() == MAX) {//想一下为什么使用while 而不是if
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        list.add(t);
        count++;
        this.notifyAll();
        return count;
    }

    public synchronized int get() {
        T t = null;
        while (list.size() == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        t = list.removeFirst();
        count--;
        this.notifyAll();
        return count;
    }

    public static void main(String[] args) {
        Container01<String> c = new Container01<>();
        //启动消费者线程
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 5; j++) {
                    System.out.println("消费者当前消费 count：" + c.get());
                }
            }, "c_"+i).start();
        }

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //启动生产者线程
        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                for (int j = 0; j < 25; j++) {
                    System.out.println("当前生产者生产count："+c.put(Thread.currentThread().getName() + "" + j));

                }
            }, "p_"+i).start();
        }
    }


}
