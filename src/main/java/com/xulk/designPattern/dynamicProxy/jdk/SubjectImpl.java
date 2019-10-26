package com.xulk.designPattern.dynamicProxy.jdk;

/**
 * Created by xulinkai on 2019/7/30.
 */
public class SubjectImpl implements Subject {
    @Override
    public void sayHello() {
        System.out.println("Hello world .......");
    }
}
