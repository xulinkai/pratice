package com.xulk.mashibing.threadLocal;

import java.util.concurrent.TimeUnit;

/**
 * Created by xulinkai on 2019/7/24.
 * ThreadLocal线程局部变量
 */
public class ThreadLocal01 {

    volatile static Pserson p = new Pserson();

    public static void main(String[] args) {
        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(p.name);
        }).start();

        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            p.name = "lihsi";
        }).start();
    }


}

class  Pserson{
    String name = "zhangsan";
}
