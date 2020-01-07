package com.xulk.mashibing.javaBasic.jdk8.zhujie;

/**
 * @description:
 * @author:
 * @create: 2019-11-07 00:19
 **/
public class Main {

    //@MyAnnotation注解可以使用在类、方法上  name、array没有默认值，所以这里必须指定，age有默认值可以不指定
    @MyAnnotation(name = "xulinkai",array = {2,3})
    public void study(int times){
        for (int i = 0; i < times; i++) {
            System.out.println("good good study, day day up");
        }
    }


}
