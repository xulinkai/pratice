package com.xulk.mashibing.designPattern.factoryMethod;

/**
 * @description:
 * @author:
 * @create: 2019-08-27 21:22
 **/
public class Main {

    public static void main(String[] args) {
        Vehicle vehicle = new Car();
        vehicle.go();

        Vehicle vehicle1 = new Train();
        vehicle1.go();

        /**
        * @Description:  工厂方法 每一种对应一个单独的工厂
        */
        Vehicle vehicle2 = new CarFactory().getCar();
        vehicle2.go();

        Vehicle vehicle3 = new TrainFactory().getTrain();
        vehicle3.go();
    }
}
