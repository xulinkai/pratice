package com.xulk.designPattern.mashibing.decorator;

/**
 * @description:
 * @author:
 * @create: 2019-09-01 18:30
 **/
public class Decorator_three extends Decorator {

    public Decorator_three(Human human) {
        super(human);
    }

    public void findClothes() {
        System.out.println("找到一件D&G。。");
    }

    public void findTheTarget() {
        System.out.println("在Map上找到神秘花园和城堡。。");
    }

    @Override
    public void wearClothes() {
        super.wearClothes();
        findClothes();
    }

    @Override
    public void walkToWhere() {
        super.walkToWhere();
        findTheTarget();
    }

}
