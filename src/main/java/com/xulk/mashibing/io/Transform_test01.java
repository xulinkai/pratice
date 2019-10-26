package com.xulk.mashibing.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by xulinkai on 2019/8/5.
 */
public class Transform_test01 {


    public static void main(String[] args) {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        //可以不使用，但是bufferedReader有readLine()的功能
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String str = null;
        try {
            str = bufferedReader.readLine();
            while (str!=null){
                if(str.equalsIgnoreCase("exit")){
                    break;
                }
                System.out.println(str.toUpperCase());
                str = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
