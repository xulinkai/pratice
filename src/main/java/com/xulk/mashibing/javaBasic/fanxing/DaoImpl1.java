package com.xulk.mashibing.javaBasic.fanxing;

/**
 * @description:
 * @author:
 * @create: 2019-11-03 21:54
 **/
public class DaoImpl1 extends Dao<Bean1> {

    public static void main(String[] args) {
        DaoImpl1 daoImpl1 = new DaoImpl1();
        //只能添加bean1类型的
        daoImpl1.add(new Bean1());
    }
}
