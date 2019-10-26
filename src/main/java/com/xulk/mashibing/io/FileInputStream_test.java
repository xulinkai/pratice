package com.xulk.mashibing.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by xulinkai on 2019/8/1.
 */
public class FileInputStream_test {

    public static void test1(){
        long num = 0;
        int b = 0;
        FileInputStream in = null;
        try {
            //两个反斜杠 或 一个正斜杠 都行
            in = new FileInputStream("E:\\知识点网址标签收藏.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            while ((b=in.read())!=-1){
                System.out.print((char) b);
                num++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(in!=null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("共读取了"+num+"个字节");
    }

    public static void test2(){
        long num = 0;
        int b = 0;
        byte[] bytes = new byte[1024];
        FileInputStream in = null;
        try {
            //两个反斜杠 或 一个正斜杠 都行
            in = new FileInputStream("E:\\知识点网址标签收藏.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            //读到了字节数组里面去
            while ((b=in.read(bytes))!=-1){
                for(int i=0;i<bytes.length;i++){
                    System.out.print(bytes[i]);
                    //out.write(bytes,0,b);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(in!=null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        test2();

    }
}
