package com.xulk.designPattern.mashibing.factoryMethod.abstractFactory;

import com.xulk.designPattern.factoryMehod.Factory;

/**
 * @description:
 * @author:
 * @create: 2019-08-27 22:40
 **/
public class Main {

    public static void main(String[] args) {
        AbstractFactory factory = new Factory_01();
        factory.createDrinks().drink();
        factory.createFood().eat();
        factory.createVehicle().go();

        AbstractFactory factory1 = new Factory_02();
        factory1.createDrinks().drink();
        factory1.createVehicle().go();
        factory1.createFood().eat();
    }
}
