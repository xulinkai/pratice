package com.xulk.mashibing.javaBasic.jdk8.zhujie;

import java.lang.reflect.Method;

/**
 * @description:  测试注解
 * @author:
 * @create: 2019-11-07 00:30
 **/
public class TestAnnotaion {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {
        Class<?> aClass = Class.forName("com.xulk.mashibing.javaBasic.jdk8.zhujie.Main");
        //这里的入参不能写Integer.class 只能写int.class
        Method study = aClass.getMethod("study", int.class);
        if(study.isAnnotationPresent(MyAnnotation.class)){
            System.out.println("study方法上配置了MyAnnotation注解");
            MyAnnotation myAnnotation = study.getAnnotation(MyAnnotation.class);
            System.out.println(myAnnotation.age());
            System.out.println(myAnnotation.name());
            System.out.println(myAnnotation.array()[1]);
        }
    }
}
