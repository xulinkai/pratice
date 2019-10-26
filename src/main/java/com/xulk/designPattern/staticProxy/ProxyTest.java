package com.xulk.designPattern.staticProxy;

/**
 * Created by xulinkai on 2019/7/29.
 * 简单工厂又称为静态工厂，
 */
public class ProxyTest {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        FruitFactory.getFruit("com.xulk.designPattern.staticProxy.Banana").eat();
    }
}
