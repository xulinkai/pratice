package com.xulk.mashibing.designPattern.state;

/**
 * @description:
 * @author:
 * @create: 2019-09-08 04:15
 **/
public class Main {

    public static void main(String[] args) {
        MM mm = new MM(new HappyState());
        mm.smile();
    }
}
