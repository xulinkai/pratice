package com.xulk.designPattern.mashibing.decorator;

/**
 * @description:
 * @author:
 * @create: 2019-09-01 18:33
 **/
public class Main {

    public static void main(String[] args) {
        Person person = new Person();
        Decorator decorator = new Decorator_one(person);
        decorator.walkToWhere();
        decorator.wearClothes();
    }
}
