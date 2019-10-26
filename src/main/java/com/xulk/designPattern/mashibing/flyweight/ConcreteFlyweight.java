package com.xulk.designPattern.mashibing.flyweight;

/**
 * @description: 具体享元角色
 * @author:
 * @create: 2019-09-07 01:06
 **/
public class ConcreteFlyweight implements Flyweight{

    private String key;

    public ConcreteFlyweight(String key) {
        this.key = key;
        System.out.println("具体享元角色："+key+"被创建");
    }


    @Override
    public void operation(UnsharedConcreteFlyweight unsharedConcreteFlyweight) {
        System.out.println("具体享元："+key+"被调用");
        System.out.println("非享元信息为："+unsharedConcreteFlyweight.getInfo());
    }
}
