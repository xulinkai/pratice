package com.xulk.mashibing.jvm;

import java.io.*;
import java.lang.reflect.Method;

public class T03_MyClassLoader extends ClassLoader {

    private String path;

    public T03_MyClassLoader(String path) {
        this.path = path;
    }

    public T03_MyClassLoader() {
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String classPath = path + name + ".class";
        InputStream inputStream = null;
        ByteArrayOutputStream outputStream = null;
        try {
            inputStream = new FileInputStream(classPath);
            outputStream = new ByteArrayOutputStream();
            int temp = 0;
            while ((temp = inputStream.read()) != -1) {
                outputStream.write(temp);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                outputStream.close();
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        byte[] bytes = outputStream.toByteArray();
        return defineClass(name, bytes, 0, bytes.length);
    }

    public static void main(String[] args) {
        T03_MyClassLoader myClassLoader = new T03_MyClassLoader("D:test\\");
        try {
            Class clazz = myClassLoader.findClass("Hello");
            System.out.println(clazz);
            Object o = clazz.newInstance();
            System.out.println(o.getClass().getClassLoader());
            Method m = clazz.getDeclaredMethod("m");
            m.invoke(o);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
