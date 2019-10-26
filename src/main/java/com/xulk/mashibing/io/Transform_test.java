package com.xulk.mashibing.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * Created by xulinkai on 2019/8/5.
 * 转换流：用于字符流和字节流之间的相互转换
 *
 * OutputStreamWriter  将outputstream转为writer
 *
 */
public class Transform_test {

    public static void main(String[] args) throws IOException {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream("E:\\xulk.txt"));
        outputStreamWriter.write("this is xulinkai ");
        outputStreamWriter.write("this is yangyuqing");
        System.out.println(outputStreamWriter.getEncoding());
        outputStreamWriter = new OutputStreamWriter(new FileOutputStream("E:\\xulk.txt",true),"ISO8859_1");
        outputStreamWriter.write("this is yangyuqing");
        System.out.println(outputStreamWriter.getEncoding());
        outputStreamWriter.close();
    }

}
