package com.xulk.mashibing.designPattern.memento;

import java.io.*;

/**
 * @description:  目标对象写入磁盘
 *                  对象必须实现serializable接口
 * @author:
 * @create: 2019-09-08 03:47
 **/
public class Test {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File file = new File("c:/xulinkai.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
        objectOutputStream.writeObject(new Object());


        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file));
        Object object = inputStream.readObject();
    }
}
