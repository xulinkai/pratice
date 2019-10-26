package com.xulk.designPattern.dynamicProxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by xulinkai on 2019/7/30.
 * newProxyInstance方法执行了以下几种操作。
 * 1.生成一个实现了参数interfaces里所有接口且继承了Proxy的代理类的字节码，然后用参数里的classLoader加载这个代理类到jvm
 * 2.使用代理类父类的构造函数 Proxy(InvocationHandler h)，来创造一个代理类的实例将我们自定义的InvocationHandler的子类传入。
 * 3.返回这个代理类实例。
 * 在main方法中加入System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true")，
 * 这样就会把生成的代理类Class文件保存在本地磁盘上，然后再反编译可以得到代理类的源码：
 *
 */
public class JdkDynamicProxy implements InvocationHandler{

    private Object target;//需要代理的目标对象

    /**
     * 通过目标对象获取代理对象
     * @param target
     * @return
     */
    public Object getProxyObject(Object target){
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }

    /**
     * 代理类执行方法的时候，最终都会走到当前invoke方法中，
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("目标方法执行前........");
        Object result = null;
        result = method.invoke(target,args);
        System.out.println("目标方法执行后.......");
        return result;
    }

    public static void main(String[] args) {
        JdkDynamicProxy proxy = new JdkDynamicProxy();
        Subject subject = new SubjectImpl();
        Subject sub= (Subject) proxy.getProxyObject(subject);
        sub.sayHello();
    }
}
