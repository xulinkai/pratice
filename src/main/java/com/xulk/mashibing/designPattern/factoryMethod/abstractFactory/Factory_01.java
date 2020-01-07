package com.xulk.mashibing.designPattern.factoryMethod.abstractFactory;

/**
 * @description:
 * @author:
 * @create: 2019-08-27 22:34
 **/
public class Factory_01 extends AbstractFactory {
    @Override
    public Vehicle createVehicle() {
        return new Vehicle_01();
    }

    @Override
    public Food createFood() {
        return new Food_01();
    }

    @Override
    public Drinks createDrinks() {
        return new Drinks_01();
    }
}
