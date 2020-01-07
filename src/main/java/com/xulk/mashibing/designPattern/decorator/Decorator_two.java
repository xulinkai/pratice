package com.xulk.mashibing.designPattern.decorator;

/**
 * @description:
 * @author:
 * @create: 2019-09-01 18:29
 **/
public class Decorator_two extends Decorator {

    public Decorator_two(Human human) {
        super(human);
    }

    public void goClothespress() {
        System.out.println("去衣柜找找看。。");
    }

    public void findPlaceOnMap() {
        System.out.println("在Map上找找。。");
    }

    @Override
    public void wearClothes() {
        super.wearClothes();
        goClothespress();
    }

    @Override
    public void walkToWhere() {
        super.walkToWhere();
        findPlaceOnMap();
    }

}
