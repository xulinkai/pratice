package com.xulk.mashibing.designPattern.flyweight;

/**
* @Description: 抽象享元角色
* @Param:
* @return:
* @Date: 2019/9/7  1:05
*/
public interface Flyweight {

    public void operation(UnsharedConcreteFlyweight unsharedConcreteFlyweight);
}
