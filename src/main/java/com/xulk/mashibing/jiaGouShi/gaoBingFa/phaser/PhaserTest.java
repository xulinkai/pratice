package com.xulk.mashibing.jiaGouShi.gaoBingFa.phaser;

import java.util.concurrent.Phaser;

/**
 * @description: 分阶段，每个阶段都是一个栅栏
 * @author: xulk
 * @create: 2020-10-27 19:15
 **/
public class PhaserTest {

    static MyPhaser myPhaser = new MyPhaser();

    public static void main(String[] args) {
        myPhaser.bulkRegister(7);
        for (int i = 0; i < 5; i++) {
            new Thread(new Person("p_"+i)).start();
        }
        new Thread(new Person("新郎")).start();
        new Thread(new Person("新娘")).start();

    }

    static class MyPhaser extends Phaser {
        @Override
        protected boolean onAdvance(int phase, int registeredParties) {
            switch (phase) {
                case 0:
                    System.out.println("所有人都到齐了！ \n" + registeredParties);
                    System.out.println();
                    return false;
                case 1:
                    System.out.println("所有人都吃完了！ \n" + registeredParties);
                    System.out.println();
                    return false;
                case 2:
                    System.out.println("所有人都离开了！\n" + registeredParties);
                    return false;
                case 3:
                    System.out.println("婚礼结束！\n");
                    return true;
            }
            return true;
        }
    }

    static class Person implements Runnable {
        private String name;

        public Person(String name) {
            this.name = name;
        }

        void arrive() {
            System.out.printf("%s 到达了 \n", name);
            myPhaser.arriveAndAwaitAdvance();
        }
        void eat(){
            System.out.printf("%s 吃完了 \n", name);
            myPhaser.arriveAndAwaitAdvance();
        }
        void leave(){
            System.out.printf("%s 离开了 \n", name);
            myPhaser.arriveAndAwaitAdvance();
        }
        void hug(){
            if("新郎新娘".contains(name)){
                System.out.printf("%s 洞房了 \n", name);
                myPhaser.arriveAndAwaitAdvance();
            }else{
                myPhaser.arriveAndDeregister();
            }
        }

        @Override
        public void run() {
            arrive();
            eat();
            leave();
            hug();
        }
    }
}
