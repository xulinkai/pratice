package com.xulk.mashibing.designPattern.facade;

/**
 * @description:
 * @author:
 * @create: 2019-08-28 22:06
 **/
public class Client {

    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.methodA();
        facade.methodB();
    }
}
