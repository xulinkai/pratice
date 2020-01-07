package com.xulk.mashibing.designPattern.factoryMethod;

/**
 * @description:  简单工厂的扩展性不好
 * @author:
 * @create: 2019-08-27 21:23
 **/
public class SimpleVehicleFactory {

    public Car getCar(){
        //可以加一些权限控制
        return new Car();
    }

    public Train getTrain(){
        return new Train();
    }
}
