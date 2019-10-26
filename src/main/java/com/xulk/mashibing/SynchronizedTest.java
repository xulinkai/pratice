package com.xulk.mashibing;

/**
 * Created by xulinkai on 2019/7/22.
 */
public class SynchronizedTest {

    private Integer i = 0;

    private Object o = new Object();

    public void method(){
        //任何线程想要执行下面的代码,必须要获得o的锁， o可以不是new出来的一个object，也可以用this代替
        //锁定的是一个对象  如果synchronized 锁的是整个方法，此关键字也可以直接放在方法上
        //锁定的不是一段代码，而是当前对象（synchronized object、this或放在方法上，都是锁定的对象）
        //synchronized 用在静态方法上，相当于锁定的是当前class对象，
        synchronized (o){
            i++;
            System.out.println(Thread.currentThread().getName());
        }
    }
}
