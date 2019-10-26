package com.xulk.designPattern.dynamicProxy.cglib;

import org.springframework.cglib.proxy.Enhancer;

/**
 * Created by xulinkai on 2019/7/30.
 * https://blog.csdn.net/yhl_jxy/article/details/80633194
 */
public class CglibTest {

    public static void main(String[] args) {
        // 代理类class文件存入本地磁盘方便我们反编译查看源码
        //System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "D:\\code");
        //通过cglib动态代理获取代理对象的过程
        Enhancer enhancer = new Enhancer();
        //设置父类
        enhancer.setSuperclass(HelloService.class);
        //设置回调对象
        enhancer.setCallback(new MyMethodInterceptor());
        //创建代理对象
        HelloService helloService = (HelloService) enhancer.create();
        //执行目标方法
        helloService.sayHello();//非final方法可以正常被代理，插入前置、后置通知，
        helloService.sayOthres("xulinkai");//final 修饰的方法不能被代理，无法插入通知
    }
}
