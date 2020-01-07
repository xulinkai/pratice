package com.xulk.mashibing.designPattern.bridge;

/**
 * @description:
 * @author:
 * @create: 2019-09-08 01:52
 **/
public class GG {

    public static void give(Gift gift){
        System.out.println("送花。。。。。。。。。");
    }

    public static void main(String[] args) {
        //送了一本。。。。样的书
        give(new WildFlower(new Book()));
    }
}
