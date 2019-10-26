package com.xulk.designPattern.staticProxy;

/**
 * Created by xulinkai on 2019/7/29.
 * 工厂里面提供一个静态方法
 */
public class FruitFactory {

    public static Fruit getFruit(String className) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<?> aClass = Class.forName(className);
        return (Fruit) aClass.newInstance();
    }
}
