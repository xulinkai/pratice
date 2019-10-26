package com.xulk.designPattern.factoryMehod;

/**
 * Created by xulinkai on 2019/7/29.
 * 更符合开-闭原则
 新增一种产品时，只需要增加相应的具体产品类和相应的工厂子类即可,简单工厂模式需要修改工厂类的判断逻辑
 符合单一职责原则
 每个具体工厂类只负责创建对应的产品,简单工厂中的工厂类存在复杂的switch逻辑判断
 不使用静态工厂方法，可以形成基于继承的等级结构。简单工厂模式的工厂类使用静态工厂方法
 */
public class FactoryTest {

    public static void main(String[] args) {
        FactoryA factoryA = new FactoryA();
        factoryA.manufacture().show();

        FactoryB factoryB = new FactoryB();
        factoryB.manufacture().show();
    }
}
