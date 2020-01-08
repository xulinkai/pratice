package com.xulk.mashibing.jiaGouShi.gaoBingFa.countDownLatch;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by xulinkai on 2019/7/22.
 * 实现一个容器 提供add和size方法，
 * 两个线程，一个线程往里面添加添加10个元素，另外一个线程监控容器，达到五个元素的时候，结束线程
 *程序无法实现功能，因为变量线程1和线程2并不是同时可见，线程2无法监听到变量值的变化
 *
 */
public class MyContainer01 {

    List<String> list = new ArrayList<>();

    public void add(String string){
        list.add(string);
    }
    public int size(){
        return list.size();
    }

    public static void main(String[] args) {
        MyContainer01 my = new MyContainer01();
        new Thread(()->{
            for (int i = 0; i <10 ; i++) {
                my.add(i+"string");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("add "+i);
            }
        },"t1").start();

        new Thread(()->{
            while (true){
                if(my.size() == 5){
                    break;
                }
            }
            System.out.println("t2 结束");
        },"t2").start();
    }
}
