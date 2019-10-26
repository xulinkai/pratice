package com.xulk.mashibing.threadPool;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by xulinkai on 2019/8/8.
 */
public class ParallelStreamAPI {


    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            list.add(1000000 + random.nextInt(1000000));
        }
        long start = System.currentTimeMillis();
        list.forEach(v->isPrime(v));
        long end = System.currentTimeMillis();
        System.out.println(end-start);

        //使用stream api
        start = System.currentTimeMillis();
        //默认使用多线程
        list.parallelStream().forEach(ParallelStreamAPI::isPrime);
        end = System.currentTimeMillis();
        System.out.println(end-start);

    }

    static  boolean isPrime(Integer integer) {
        for (int i = 2; i <= integer / 2; i++) {
            if (integer % i == 0) {
                return false;
            }
        }
        return true;
    }

}
