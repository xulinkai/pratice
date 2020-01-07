package com.xulk.mashibing.designPattern.singleton;

/**
 * @description:  单例模式之懒汉式
 *                 synchronized  普通方法上 锁当前对象
 *                               静态方法上， 锁当前类的class对象
 * @author:
 * @create: 2019-08-21 22:31
 **/
public class LanHan_02 {

    private static LanHan_02 lanHan_01;

    private LanHan_02(){

    }

    public synchronized static LanHan_02 getInstance(){
        if(lanHan_01 == null){
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lanHan_01 = new LanHan_02();
        }
        return lanHan_01;
    }

    public static void main(String[] args) {
        for (int i = 0; i <100 ; i++) {
            new Thread(()->{
                System.out.println(LanHan_02.getInstance().hashCode());
            }).start();

        }
    }
}
