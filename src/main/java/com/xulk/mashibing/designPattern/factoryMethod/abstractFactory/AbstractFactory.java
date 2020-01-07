package com.xulk.mashibing.designPattern.factoryMethod.abstractFactory;

/**
 * @description:
 * @author:
 * @create: 2019-08-27 22:33
 **/
public abstract class AbstractFactory {

    public abstract Vehicle createVehicle();

    public abstract Food createFood();

    public abstract Drinks createDrinks();
}
