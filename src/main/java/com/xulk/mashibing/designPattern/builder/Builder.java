package com.xulk.mashibing.designPattern.builder;

/**
 * @description:
 * @author:
 * @create: 2019-09-08 00:56
 **/
public abstract class Builder {

    public Product product = new Product();

    public abstract Builder buildPartA();

    public abstract Builder buildPartB();

    public abstract Builder buildPartC();

    public Product getResult(){
        return product;
    };
}
