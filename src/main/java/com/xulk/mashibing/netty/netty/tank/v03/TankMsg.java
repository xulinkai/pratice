package com.xulk.mashibing.netty.netty.tank.v03;

/**
 * @description:
 * @author:
 * @create: 2020-01-05 16:06
 **/
public class TankMsg {
    public int x, y;

    public TankMsg(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "TankMsg{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
