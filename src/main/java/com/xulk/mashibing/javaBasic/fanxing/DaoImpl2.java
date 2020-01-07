package com.xulk.mashibing.javaBasic.fanxing;

/**
 * @description:
 * @author:
 * @create: 2019-11-03 21:55
 **/
public class DaoImpl2 extends Dao<Bean2> {

    public static void main(String[] args) {
        DaoImpl2 daoImpl2 = new DaoImpl2();
        //只能添加Bean2类型的
        daoImpl2.add(new Bean2());
    }
}
