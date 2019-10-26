package com.xulk.designPattern.mashibing.singleton;

/**
 * @description:    EHan_01 和 EHan_02 基本完全一样
 * @author:
 * @create: 2019-08-21 22:17
 **/
public class EHan_02 {

    private static final EHan_02 E_HAN;

    static {
        E_HAN = new EHan_02();
    }

    private EHan_02(){

    }

    public static EHan_02 getInstance(){
        return E_HAN;
    }

    public static void main(String[] args) {
        EHan_02 eHan01 = getInstance();
        EHan_02 eHan02 = getInstance();
        System.out.println(eHan01==eHan02);
    }
}
