package com.xulk.mashibing.designPattern.builder;

/**
 * @description:
 * @author:
 * @create: 2019-09-08 01:06
 **/
public class Client {

    public static void main(String[] args) {

        Builder builder = new ConcreteBuilder();
        Director director = new Director(builder);
        Product contruct = director.contruct();
        contruct.show();

    }
}
