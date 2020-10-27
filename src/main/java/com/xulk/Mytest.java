package com.xulk;

/**
 * @Description
 * @Author xulinkai
 * @DATE 2020/8/31 22:47
 */
public class Mytest extends Thread{

    public Mytest(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 1; i <= 50; i++) {
            System.out.println("" + this.getName() + "-----" + i);
            // 当i为30时，该线程就会把CPU时间让掉，让其他或者自己的线程执行（也就是谁先抢到谁执行）
            if (i == 30) {
                this.yield();
            }
        }
    }

    public static void main(String[] args) {
        Mytest yt1 = new Mytest("张三");
        Mytest yt2 = new Mytest("李四");
        yt1.start();
        yt2.start();
    }
}
