package com.xulk.mashibing.javaBasic.fanxing;

/**
 * @description:
 * @author:
 * @create: 2019-11-03 21:43
 **/
public class FanxingClass<T> {

    private T t;
    private String string;

    @Override
    public String toString() {
        return "FanxingClass{" +
                "t=" + t +
                ", string='" + string + '\'' +
                '}';
    }
}
