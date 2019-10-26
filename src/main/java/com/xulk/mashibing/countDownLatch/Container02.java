package com.xulk.mashibing.countDownLatch;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by xulinkai on 2019/7/24.
 * 写一个固定容量同步器，拥有put和get方法，一级getCount方法，
 * 能够支持两个生产者线程以及10个消费者线程的阻塞调用，
 * <p>
 * 使用wait notify和notifyAll来实现
 * <p>
 * 使用lock和condition来实现，对比两种方式，condition方式可以更加精确的指定哪些线程被唤醒
 */
public class Container02<T> {

    final private LinkedList<T> list = new LinkedList<>();
    final private int MAX = 10;
    private int count = 0;

    private Lock lock = new ReentrantLock();
    private Condition product = lock.newCondition();
    private Condition consume = lock.newCondition();


    public synchronized void put(T t) {
        try {
            lock.lock();
            while (list.size() == MAX) {
                product.wait();
            }
            list.add(t);
            count++;
            consume.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public synchronized int get() {
        T t = null;
        lock.lock();
        try {
            while (list.size() == 0){
                consume.await();
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
        t = list.removeFirst();
        count--;
        product.signalAll();
        return count;
    }

    public static void main(String[] args) {
        Container02<String> c = new Container02<>();
        //启动消费者线程
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 5; j++) {
                    System.out.println("消费者当前消费 count：" + c.get());
                }
            }, "c_" + i).start();
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
                    c.put(Thread.currentThread().getName() + "" + j);
                }
            }, "p_" + i).start();
        }
    }


}
