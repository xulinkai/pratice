package com.xulk.designPattern.mashibing.flyweight;

/**
 * @description:
 * @author:
 * @create: 2019-09-07 01:17
 **/
public class Main {


    public static void main(String[] args) {
        FlyweightFactory factory = new FlyweightFactory();
        Flyweight c1 =  factory.getFlyweight("a");
        Flyweight c2 =  factory.getFlyweight("a");
        Flyweight c3 =  factory.getFlyweight("a");
        Flyweight c4 =  factory.getFlyweight("b");
        Flyweight c5 =  factory.getFlyweight("b");
        Flyweight c6 =  factory.getFlyweight("b");
        System.out.println(factory.getFlyweights().size());
        c1.operation(new UnsharedConcreteFlyweight("调用非享元角色"));
    }
}
