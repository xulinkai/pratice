package com.xulk.designPattern.mashibing.decorator;

/**
 * @description:
 * @author:
 * @create: 2019-09-01 18:27
 **/
public class Decorator_one extends Decorator {

    public Decorator_one(Human human) {
        super(human);
    }

    public void goHome() {
        System.out.println("进房子。。");
    }

    public void findMap() {
        System.out.println("书房找找Map。。");
    }

    @Override
    public void wearClothes() {
        super.wearClothes();
        goHome();
    }

    @Override
    public void walkToWhere() {
        super.walkToWhere();
        findMap();
    }

}
