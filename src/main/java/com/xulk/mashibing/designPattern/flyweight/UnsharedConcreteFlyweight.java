package com.xulk.mashibing.designPattern.flyweight;

/**
 * @description:  非享元角色
 * @author:
 * @create: 2019-09-07 01:03
 **/
public class UnsharedConcreteFlyweight {

    private String info;

    public UnsharedConcreteFlyweight(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
