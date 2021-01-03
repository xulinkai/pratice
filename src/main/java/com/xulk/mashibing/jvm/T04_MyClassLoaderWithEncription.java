package com.xulk.mashibing.jvm;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * 利用classLoader进行class文件加密
 */
public class T04_MyClassLoaderWithEncription extends ClassLoader{

    public static int seed = 0B10110110;

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        File f = new File("c:/test/", name.replace('.', '/').concat(".msbclass"));
        try {
            FileInputStream fis = new FileInputStream(f);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int b = 0;
            while ((b=fis.read()) !=0) {
                /**
                 * 操作两次变回原来的值
                 */
                baos.write(b ^ seed);
            }
            byte[] bytes = baos.toByteArray();
            baos.close();
            fis.close();//可以写的更加严谨
            return defineClass(name, bytes, 0, bytes.length);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return super.findClass(name); //throws ClassNotFoundException
    }



    private static void encFile(String name) throws Exception {
        String parent = "D:test/";
        File f = new File(parent, name.replace('.', '/').concat(".class"));
        FileInputStream fis = new FileInputStream(f);
        FileOutputStream fos = new FileOutputStream(new File(parent, name.replaceAll(".", "/").concat(".msbclass")));
        int b = 0;
        while((b = fis.read()) != -1) {
            fos.write(b ^ seed);
        }
        fis.close();
        fos.close();
    }

    public static void main(String[] args) throws Exception {
        encFile("com.xulk.mashibing.jvm.Hello");
        ClassLoader l = new T04_MyClassLoaderWithEncription();
        Class clazz = l.loadClass("com.xulk.mashibing.jvm.Hello");
        System.out.println(l.getClass().getClassLoader());
        System.out.println(l.getParent());
    }
}
