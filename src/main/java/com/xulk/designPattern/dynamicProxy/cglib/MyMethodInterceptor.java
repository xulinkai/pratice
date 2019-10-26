package com.xulk.designPattern.dynamicProxy.cglib;


import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by xulinkai on 2019/7/30.
 */
public class MyMethodInterceptor implements MethodInterceptor {


    /**
     *
     * @param sub           cblib生成的代理对象
     * @param method        被代理对象方法（要被拦截的方法）
     * @param objects       方法的入参（被拦截方法的参数）
     * @param methodProxy  要触发父类的方法对象
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object sub, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("插入前置通知.........");
        Object object = methodProxy.invokeSuper(sub,objects);
        System.out.println("插入后置通知.........");
        return object;
    }
}
