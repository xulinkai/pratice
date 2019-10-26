package com.xulk.designPattern.singleton;

/**
 * Created by xulinkai on 2019/7/29.
 * 线程安全、懒加载  实现单例模式
 * 构造方法私有化
 * synchronized没有必要锁整个方法，
 * 初始化的时候不加载，使用的时候再去加载
 */
public class Sington1 {

    private static Sington1 sington1;

    private  Sington1(){

    }

    private Sington1 getSington1(){
        if(sington1 == null){
            synchronized (Sington1.class){
                if(sington1 == null){
                    sington1 = new Sington1();
                }
            }
        }
        return sington1;
    }


}
