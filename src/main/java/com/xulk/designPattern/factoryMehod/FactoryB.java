package com.xulk.designPattern.factoryMehod;

/**
 * Created by xulinkai on 2019/7/29.
 */
public class FactoryB extends Factory {
    @Override
    public Product manufacture() {
        return new ProductB();
    }

}
