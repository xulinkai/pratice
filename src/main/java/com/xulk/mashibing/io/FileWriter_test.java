package com.xulk.mashibing.io;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by xulinkai on 2019/8/1.
 */
public class FileWriter_test {

    public static void main(String[] args) {
        int b = 0;
        FileWriter writer = null;
        try {
            writer = new FileWriter("E:\\xulk.txt");
            for (int i = 0; i <50000 ; i++) {
                writer.write(i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(writer!=null){
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
