package com.xulk.mashibing.designPattern.proxy.staticProxy;

/**
 * @description:
 * @author:
 * @create: 2019-09-07 02:00
 **/
public class Tank implements Moveable {
    @Override
    public void move() {
        long start = System.currentTimeMillis();
        System.out.println("tank is moving honglonglong");
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }
}
