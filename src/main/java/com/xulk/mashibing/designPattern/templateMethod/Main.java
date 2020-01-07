package com.xulk.mashibing.designPattern.templateMethod;

/**
 * @description:
 * @author:
 * @create: 2019-09-08 04:01
 **/
public class Main {

    public static void main(String[] args) {
        F f = new C();
        f.m();
    }
}

abstract class F{

    //相当于一个模板，模板里面调用具体的方法
    public void m(){
        m1();
        m2();
    }

    public abstract void m1();

    public abstract void m2();
}

class C extends F {

    @Override
    public void m1() {
        System.out.println("m1");
    }

    @Override
    public void m2() {
        System.out.println("m2");
    }
}
