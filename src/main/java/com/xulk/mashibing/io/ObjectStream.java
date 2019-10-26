package com.xulk.mashibing.io;

import java.io.*;

/**
 * Created by xulinkai on 2019/8/5.
 */
public class ObjectStream {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        TestBean testBean = new TestBean();
        testBean.name = "xulinkai";
        testBean.id = "itw_xulk";
        testBean.age = 26;
        FileOutputStream outputStream = new FileOutputStream("E://xulinkai.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(testBean);
        objectOutputStream.flush();
        objectOutputStream.close();

        FileInputStream inputStream = new FileInputStream("E://xulinkai.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        TestBean bean = (TestBean) objectInputStream.readObject();
        System.out.println(bean);
    }

}
