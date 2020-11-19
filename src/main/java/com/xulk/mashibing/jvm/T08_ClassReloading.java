package com.xulk.mashibing.jvm;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class T08_ClassReloading {

    private static class MyLoader extends ClassLoader {
        @Override
        public Class<?> loadClass(String name) throws ClassNotFoundException {
            File f = new File("E:/spacework/ideaworkspace/pratice/target/classes/" + name.replace(".", "/").concat(".class"));
            if (!f.exists()) return super.loadClass(name);
            try {
                InputStream is = new FileInputStream(f);
                byte[] b = new byte[is.available()];
                is.read(b);
                return defineClass(name, b, 0, b.length);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return super.loadClass(name);
        }
    }

    public static void main(String[] args) throws ClassNotFoundException {
        MyLoader m = new MyLoader();
        Class clazz = m.loadClass("com.xulk.mashibing.jvm.Hello");
        m = new MyLoader();
        Class clazzNew = m.loadClass("com.xulk.mashibing.jvm.Hello");
        System.out.println(clazz == clazzNew);
    }

}
