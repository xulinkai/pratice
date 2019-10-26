package com.xulk.designPattern.mashibing.proxy.staticProxy;

/**
 * @description:
 * @author:
 * @create: 2019-09-07 02:04
 **/
public class Main {

    public static void main(String[] args) {
        new TimePorxy(new Tank()).move();
        new LogProxy(new TimePorxy(new Tank())).move();
    }
}
