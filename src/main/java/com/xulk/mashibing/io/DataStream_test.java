package com.xulk.mashibing.io;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * Created by xulinkai on 2019/8/5.
 * dataOutputStream 可以直接写数值型的数据
 */
public class DataStream_test {

    public static void main(String[] args) throws IOException {
        ByteOutputStream byteOutputStream = new ByteOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteOutputStream);
        dataOutputStream.writeDouble(Math.random());//double 8个字节
        dataOutputStream.writeBoolean(true);// boolean 1个字节
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteOutputStream.toByteArray());
        System.out.println(byteArrayInputStream.available());//还有多少字节可以读  9
        DataInputStream dataInputStream = new DataInputStream(byteArrayInputStream);
        System.out.println(dataInputStream.readDouble());
        System.out.println(dataInputStream.readBoolean());
        dataOutputStream.close();
        dataInputStream.close();

    }
}
