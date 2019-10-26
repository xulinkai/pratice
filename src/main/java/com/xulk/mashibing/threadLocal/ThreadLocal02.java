package com.xulk.mashibing.threadLocal;

import java.util.concurrent.TimeUnit;

/**
 * Created by xulinkai on 2019/7/24.
 * threadLocal线程局部变量
 *
 * ThreadLocal是使用空间换时间，synchronized是使用时间换空间
 * 比如hibernate中session就挂载在ThreadLocal中，避免使用synchronized，
 *
 * 相当于，对象在每个线程之间拷贝了一份，互不影响，空间换时间
 */
public class ThreadLocal02 {
    static  ThreadLocal<Person2> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(threadLocal.get());
        }).start();

        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            threadLocal.set(new Person2());
        }).start();
    }

}

class Person2{
    String name = "zhangsan";
}
