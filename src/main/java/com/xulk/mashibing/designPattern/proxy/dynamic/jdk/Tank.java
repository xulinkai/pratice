package com.xulk.mashibing.designPattern.proxy.dynamic.jdk;

/**
 * @description:
 * @author:
 * @create: 2019-09-07 02:16
 **/
public class Tank implements Moveable {
    @Override
    public void move() {
        System.out.println("tank is moving  honglonglong........");
    }

    @Override
    public void go() {
        System.out.println(" go to school");
    }
}
