package com.xulk.mashibing.designPattern.singleton;

/**
 * @description:    单例模式之恶汉式
 *
 * 类加载到内存后，就会实例化一个单例，JVM保证线程安全
 * 简单实用，推荐使用
 *
 *                  构造方法私有化
 *                  提供static的获取实例的方法
 *                  类装载的时候直接装载需要的实例
 *
 *                  缺点：不管使用与否，类装载的时候就会完成实例化
 * @author:
 * @create: 2019-08-21 22:17
 **/
public class EHan_01 {

    private static final EHan_01 E_HAN = new EHan_01();

    private EHan_01(){

    }

    public static EHan_01 getInstance(){
        return E_HAN;
    }

    public static void main(String[] args) {
        EHan_01 eHan01 = getInstance();
        EHan_01 eHan02 = getInstance();
        System.out.println(eHan01==eHan02);
    }
}
