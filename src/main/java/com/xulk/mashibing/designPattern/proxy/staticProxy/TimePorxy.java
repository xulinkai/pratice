package com.xulk.mashibing.designPattern.proxy.staticProxy;

/**
 * @description:
 * @author:
 * @create: 2019-09-07 02:03
 **/
public class TimePorxy implements Moveable {

    private Moveable moveable;

    public TimePorxy(Moveable moveable) {
        this.moveable = moveable;
    }

    @Override
    public void move() {
        System.out.println("当前时间");
        moveable.move();
    }
}
