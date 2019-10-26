package com.xulk.mashibing.io;

import java.io.*;

/**
 * Created by xulinkai on 2019/8/1.
 */
public class BufferedStream_test2 {

    public static void main(String[] args) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("E:\\xulk.txt"));
            BufferedReader reader = new BufferedReader(new FileReader("E:\\知识点网址标签收藏.txt"));
            String s = null;
            for (int i = 0; i <100 ; i++) {
                s = String.valueOf(Math.random());
                writer.write(s);
                writer.newLine();
            }
            writer.flush();
            while ((s=reader.readLine())!=null){
                System.out.println(s);
            }
            writer.close();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
