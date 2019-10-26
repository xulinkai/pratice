package com.xulk.designPattern.mashibing.facade;

/**
 * @description:
 * @author:
 * @create: 2019-08-28 21:59
 **/
public class Facade {



    public void methodA(){
        SubSystemOne one = new SubSystemOne();
        SubSystemThree three = new SubSystemThree();
        one.methodOne();
        three.methodThree();
    }

    public void methodB(){
        SubSystemTwo two = new SubSystemTwo();
        SubSystemFour four = new SubSystemFour();
        two.methodTwo();
        four.methodFour();
    }
}
