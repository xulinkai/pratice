package com.xulk.designPattern.mashibing.proxy.dynamic.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @description:
 * @author:
 * @create: 2019-09-07 02:14
 **/
public class Main {

    public static void main(String[] args) {
        Tank tank = new Tank();
        //参数1 用哪一个classLoader将返回的代理对象load到内存
        //参数2 代理对象应该实现的接口
        //参数3 被代理对象方法被调用的时候应该怎么做
        Moveable moveable = (Moveable) Proxy.newProxyInstance(Tank.class.getClassLoader(), new Class[]{Moveable.class},
                new InvocationHandler() {

                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("method: " + method.getName() + " start .........");
                        Object o = method.invoke(tank, args);
                        System.out.println("method: " + method.getName() + " end .........");
                        return o;
                    }
                });
        moveable.move();
    }
}
