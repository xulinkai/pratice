package com.xulk.designPattern.mashibing.decorator;

/**
 * @description:  定义被装饰者
 * @author:
 * @create: 2019-09-01 18:31
 **/
public class Person implements Human {


    @Override
    public void wearClothes() {
        System.out.println("穿什么呢。。。。。");
    }

    @Override
    public void walkToWhere() {
        System.out.println("去哪里呢。。。。");
    }
}
