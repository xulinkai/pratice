package com.xulk.mashibing.designPattern.flyweight;

import java.util.HashMap;

/**
 * @description: 创建享元的工厂
 * @author:
 * @create: 2019-09-07 01:11
 **/
public class FlyweightFactory {

    private HashMap<String, Flyweight> flyweights = new HashMap<>();

    public Flyweight getFlyweight(String key) {
        Flyweight flyweight = flyweights.get(key);
        if (flyweight != null) {
            System.out.println(key + "享元存在，已成功获取");
        } else {
            flyweight = new ConcreteFlyweight(key);
            flyweights.put(key, flyweight);
        }
        return flyweight;
    }

    public HashMap<String, Flyweight> getFlyweights() {
        return flyweights;
    }
}
