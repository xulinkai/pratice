package com.xulk.mashibing.designPattern.proxy.dynamic.cglib;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @description:
 * @author:
 * @create: 2019-09-07 10:16
 **/
public class TimeMethodInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        // o 是生成的代理对象
        System.out.println(o.getClass().getSuperclass().getName());
        System.out.println("before...........");
        Object result = null;
        result = methodProxy.invokeSuper(o,objects);
        System.out.println("after............");
        return result;
    }
}
