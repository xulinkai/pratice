package com.xulk.mashibing.io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by xulinkai on 2019/8/1.
 */
public class FileReader_test {

    public static void main(String[] args) {
        int b = 0;
        FileReader reader = null;
        try {
            reader = new FileReader("E:\\知识点网址标签收藏.txt");
            while ((b=reader.read())!=-1){
                System.out.print((char) b);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(reader != null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
