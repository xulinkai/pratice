package com.xulk.mashibing.designPattern.builder;

/**
 * @description:  指挥者：调用建造者中的方法完成复杂对象的创建。
 * @author:
 * @create: 2019-09-08 01:04
 **/
public class Director {

    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public Product contruct(){
        builder.buildPartA().buildPartB().buildPartC();
        return builder.getResult();
    }
}
