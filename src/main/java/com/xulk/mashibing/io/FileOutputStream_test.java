package com.xulk.mashibing.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by xulinkai on 2019/8/1.
 */
public class FileOutputStream_test {

    public static void main(String[] args) {
        int b = 0;
        FileInputStream inputStream = null;
        FileOutputStream outputStream = null;
        try {
            inputStream = new FileInputStream("E:\\知识点网址标签收藏.txt");
            outputStream = new FileOutputStream("E:\\xulk.txt");
            while((b = inputStream.read())!= -1){
                outputStream.write(b);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(inputStream!= null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(outputStream!=null){
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("文件已复制");
    }
}
