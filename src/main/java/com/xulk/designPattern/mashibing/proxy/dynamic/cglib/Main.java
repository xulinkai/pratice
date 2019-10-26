package com.xulk.designPattern.mashibing.proxy.dynamic.cglib;

import org.springframework.cglib.proxy.Enhancer;

/**
 * @description:
 * @author:
 * @create: 2019-09-07 10:18
 **/
public class Main {

    public static void main(String[] args) {
        //增强
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Tank.class);
        enhancer.setCallback(new TimeMethodInterceptor());
        Tank tank = (Tank) enhancer.create();
        tank.move();
    }
}
