package com.xulk.mashibing.designPattern.adapter;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @description:   InputStreamReader 这里的作用就相当于一个转换器
 * @author:
 * @create: 2019-09-08 01:28
 **/
public class Adapter {

    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("c://test.txt");
        InputStreamReader reader = new InputStreamReader(fileInputStream);
        BufferedReader bufferedReader = new BufferedReader(reader);
        String line  = bufferedReader.readLine();
        while (line != null && !"".equals(line)){
            System.out.println(line);
        }
        bufferedReader.close();
    }
}
