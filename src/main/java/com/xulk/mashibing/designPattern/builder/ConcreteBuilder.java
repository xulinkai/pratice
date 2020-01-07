package com.xulk.mashibing.designPattern.builder;

/**
 * @description:  具体的构造器
 * @author:
 * @create: 2019-09-08 01:00
 **/
public class ConcreteBuilder extends Builder {

    @Override
    public Builder buildPartA() {
        product.setPartA("构造了partA()");
        return this;
    }

    @Override
    public Builder buildPartB() {
        product.setPartB("构造了partB()");
        return this;
    }

    @Override
    public Builder buildPartC() {
        product.setPartC("构造partB()");
        return this;
    }

}
