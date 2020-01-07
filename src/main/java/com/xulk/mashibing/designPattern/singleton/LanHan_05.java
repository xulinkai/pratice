package com.xulk.mashibing.designPattern.singleton;

/**
 * @description:  完美写法
 *                        静态内部类
 *                        类装载的时候，内部类不会装载
 *
 *                        jvm保证线程安全（只加载一次类）
 *
 * @author:
 * @create: 2019-08-21 23:08
 **/
public class LanHan_05 {

    private LanHan_05(){

    }

    private static class LanHan_05_Holder{
        private  static final LanHan_05 LAN_HAN_05 = new LanHan_05();
    }

    public static LanHan_05 getInstance(){
        return LanHan_05_Holder.LAN_HAN_05;
    }

    public static void main(String[] args) {
        for (int i = 0; i <100 ; i++) {
            new Thread(()->{
                System.out.println(LanHan_05.getInstance().hashCode());
            }).start();
        }
    }

}
