package com.xulk.designPattern.mashibing.singleton;

/**
 * @description:  单例模式之懒汉式
 *                  优点：按需初始化
 *                  缺点：线程不安全
 * @author:
 * @create: 2019-08-21 22:31
 **/
public class LanHan_01 {

    private static LanHan_01 lanHan_01;

    private LanHan_01(){

    }

    public static LanHan_01 getInstance(){
        if(lanHan_01 == null){
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lanHan_01 = new LanHan_01();
        }
        return lanHan_01;
    }

    public static void main(String[] args) {
        for (int i = 0; i <100 ; i++) {
            new Thread(()->{
                System.out.println(LanHan_01.getInstance().hashCode());
            }).start();

        }
    }
}
