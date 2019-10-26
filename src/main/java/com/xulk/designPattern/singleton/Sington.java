package com.xulk.designPattern.singleton;

import java.util.Arrays;

/**
 * Created by xulinkai on 2019/7/29.
 * 实现单例模式的最好方式
 * 不用加锁，也可以实现懒加载的模式
 */
public class Sington {

    private Sington() {
        System.out.println("sington");
    }

    private static class Inner {
        private static Sington sington = new Sington();
    }

    private static Sington getSingle() {
        return Inner.sington;
    }

    public static void main(String[] args) {
        Thread[] threads = new Thread[200];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                Sington.getSingle();
            });
        }
        Arrays.asList(threads).forEach(o->o.start());
    }


}
