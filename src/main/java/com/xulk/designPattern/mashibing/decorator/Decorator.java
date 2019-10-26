package com.xulk.designPattern.mashibing.decorator;

/**
 * @description:   定义装饰者
 * @author:
 * @create: 2019-09-01 18:25
 **/
public abstract class Decorator implements Human{

    private Human human;

    public Decorator(Human human) {
        this.human = human;
    }

    public void wearClothes() {
        human.wearClothes();
    }

    public void walkToWhere() {
        human.walkToWhere();
    }

}
