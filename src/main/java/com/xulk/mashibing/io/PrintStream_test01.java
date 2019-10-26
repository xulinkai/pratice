package com.xulk.mashibing.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by xulinkai on 2019/8/5.
 */
public class PrintStream_test01 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new FileReader("E://XULINKAI.txt"));
        String str = null;
        while((str=bufferedReader.readLine())!=null){
            if(str.contains("许")||str.contains("林")||str.contains("凯")){
                System.out.println("xulk");
                System.out.println(str);
            }
        }
        bufferedReader.close();
    }
}
