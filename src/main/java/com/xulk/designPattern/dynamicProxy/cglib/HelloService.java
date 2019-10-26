package com.xulk.designPattern.dynamicProxy.cglib;

/**
 * Created by xulinkai on 2019/7/30.
 */
public class HelloService {

    public HelloService(){
        System.out.println("HelloService .......构造方法....");
    }

    /**
     * 该方法不能被子类覆盖
     * @param name
     * @return
     */
    public  final String sayOthres(String name){
        System.out.println("HelloService:sayOthers>>"+name);
        return null;
    }

    public void sayHello(){
        System.out.println("HelloService:sayHello>>.......");
    }
}
