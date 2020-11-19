package com.xulk.mashibing.jvm;

public class T02_ClassLoader {

    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> aClass = T02_ClassLoader.class.getClassLoader().loadClass("com.xulk.mashibing.jvm.ByteCode01");
        System.out.println(aClass.getName());

    }
}
