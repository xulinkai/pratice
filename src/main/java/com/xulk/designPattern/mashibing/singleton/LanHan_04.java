package com.xulk.designPattern.mashibing.singleton;

/**
 * @description: 单例模式之懒汉式
 * synchronized  普通方法上 锁当前对象
 * 静态方法上， 锁当前类的class对象
 * @author:
 * @create: 2019-08-21 22:31
 **/
public class LanHan_04 {

    private static volatile LanHan_04 lanHan_01;

    private LanHan_04() {

    }

    public static LanHan_04 getInstance() {
        //不锁整个方法，提升效率  但是不能做到 线程安全
        if (lanHan_01 == null) {
            synchronized (LanHan_04.class) {
                //双重检查
                if (lanHan_01 == null) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    lanHan_01 = new LanHan_04();
                }

            }
        }
        return lanHan_01;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(LanHan_04.getInstance().hashCode());
            }).start();
        }
    }
}
