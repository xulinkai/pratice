package com.xulk.designPattern.mashibing.factoryMethod.abstractFactory;

/**
 * @description:
 * @author:
 * @create: 2019-08-27 22:34
 **/
public class Factory_02  extends  AbstractFactory{


    @Override
    public Vehicle createVehicle() {
        return new Vehicle_02();
    }

    @Override
    public Food createFood() {
        return new Food_02();
    }

    @Override
    public Drinks createDrinks() {
        return new Drinks_02();
    }
}
