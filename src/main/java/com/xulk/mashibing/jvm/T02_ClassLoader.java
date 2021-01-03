package com.xulk.mashibing.jvm;

import java.lang.reflect.Method;

public class T02_ClassLoader {

    public static void main(String[] args) throws Exception {
        Class<?> aClass = T02_ClassLoader.class.getClassLoader().loadClass("com.xulk.mashibing.jvm.ByteCode01");
        System.out.println(aClass.getName());
        Object object = aClass.newInstance();
        Method test =aClass.getDeclaredMethod("test", String.class);
        test.invoke(object, "xxx");
    }

}
