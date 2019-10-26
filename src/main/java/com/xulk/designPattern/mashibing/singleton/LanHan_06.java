package com.xulk.designPattern.mashibing.singleton;

/**
 * @description: java创始人写的一种单例模式    枚举单例
 *                 不仅可以解决线程同步，还可以解决反序列化
 *
 *                 java
 * @author:
 * @create: 2019-08-21 23:14
 **/
public enum LanHan_06 {

    INSTANCE;

    public void m() {
        System.out.println("业务方法。。。。。。");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(LanHan_06.INSTANCE.hashCode());
            }).start();
        }
    }

}
