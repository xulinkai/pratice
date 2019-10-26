package com.xulk.mashibing.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * Created by xulinkai on 2019/8/5.
 */
public class PrintStream_test {

    public static void main(String[] args) throws FileNotFoundException {
        PrintStream printStream = null;
        FileOutputStream fileOutputStream = new FileOutputStream("E://XULINKAI.txt");
        printStream = new PrintStream(fileOutputStream);
        if (printStream != null) {
            System.setOut(printStream);//将流指向 printStream
        }
        int ln = 0;
        for (char i = 0; i <60000 ; i++) {
            System.out.print(i+"");
            if(ln++>=100){
                System.out.println();
                ln = 0;
            }
        }
    }
}
