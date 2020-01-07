package com.xulk.mashibing.designPattern.proxy.staticProxy;

/**
 * @description:
 * @author:
 * @create: 2019-09-07 02:07
 **/
public class LogProxy implements Moveable {

    Moveable moveable;

    public LogProxy(Moveable moveable) {
        this.moveable = moveable;
    }

    @Override
    public void move() {
        System.out.println("当前日志");
        moveable.move();
    }
}
