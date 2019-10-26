package com.xulk.mashibing.io;

import java.io.*;

/**
 * Created by xulinkai on 2019/8/1.
 */
public class BufferedStream_test {

    public static void main(String[] args) {
        try {
            //一根管子不合适，相当于管子套管子
            FileInputStream inputStream = new FileInputStream("E:\\知识点网址标签收藏.txt");
            BufferedInputStream in = new BufferedInputStream(inputStream);
            int c = 0;
            System.out.println(in.read());
            System.out.println(in.read());
            in.mark(100);//从第100个开始读
            for (int i = 0; i <10 && (c=in.read())!=-1 ; i++) {
                System.out.print((char) c+" ");
            }
            System.out.println();
            in.reset();//回到100个点上
            for (int i = 0; i <10 && (c=in.read())!=-1 ; i++) {
                System.out.print((char) c+" ");
            }
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
