package com.xulk.mashibing.designPattern.factoryMethod;

/**
 * @description:
 * @author:
 * @create: 2019-08-27 21:28
 **/
public class CarFactory {

    public Vehicle getCar(){
        System.out.println("创建car时候的一些其他操作....");
        return new Car();
    }
}
