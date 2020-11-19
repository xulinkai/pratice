package com.xulk.mashibing.jvm;

public class T07_ClassReloading {

    public static void main(String[] args) throws ClassNotFoundException {
        T03_MyClassLoader msbClassLoader = new T03_MyClassLoader();
        Class clazz = msbClassLoader.loadClass("com.xulk.mashibing.jvm.Hello");
        msbClassLoader = null;
        System.out.println(clazz.hashCode());
        msbClassLoader = null;
        msbClassLoader = new T03_MyClassLoader();
        Class clazz1 = msbClassLoader.loadClass("com.xulk.mashibing.jvm.Hello");
        System.out.println(clazz1.hashCode());
        System.out.println(clazz == clazz1);
    }

}
