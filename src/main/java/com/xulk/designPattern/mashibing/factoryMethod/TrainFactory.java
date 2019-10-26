package com.xulk.designPattern.mashibing.factoryMethod;

/**
 * @description:
 * @author:
 * @create: 2019-08-27 21:29
 **/
public class TrainFactory {

    public Vehicle getTrain(){
        System.out.println("创建train时候的一些其他操作......");
        return  new Train();
    }
}
