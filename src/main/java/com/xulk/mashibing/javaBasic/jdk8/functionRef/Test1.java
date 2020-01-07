package com.xulk.mashibing.javaBasic.jdk8.functionRef;

import java.util.function.Consumer;
import java.util.function.Function;

/**
 * @description:
 * @author:
 * @create: 2019-11-05 21:38
 **/
public class Test1 {

    public static void main(String[] args) {
        Function<String,Integer> function = (str)->{return  str.length();};
        System.out.println(function.apply("aaaaaaa"));

        Consumer<String> consumer = (s)->{
            System.out.println(s);
        };
        consumer.accept("xulinkai");
    }
}
