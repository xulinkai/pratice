package com.xulk.mashibing.queue;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * Created by xulinkai on 2019/8/5.
 * DelayQueue  每个元素还有多久可以拿出来
 * 可以用来执行定时任务
 */
public class DelayQueue_01 {

    //delayQueue 无界队列
    static  BlockingQueue<MyTask> tasks = new DelayQueue<>();
    Random random = new Random();

    public static void main(String[] args) throws InterruptedException {
        long now = System.currentTimeMillis();
        MyTask task1 = new MyTask(now+100);
        MyTask task2 = new MyTask(now+200);
        MyTask task3 = new MyTask(now+300);
        MyTask task4 = new MyTask(now+400);
        MyTask task5 = new MyTask(now+500);
        tasks.put(task1);
        tasks.put(task2);
        tasks.put(task3);
        tasks.put(task4);
        tasks.put(task5);
        System.out.println(tasks);
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println(tasks.take());
        }
    }
    static class MyTask implements Delayed{

        long runningTime ;

        @Override
        public long getDelay(TimeUnit unit) {
            return unit.convert(runningTime - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }

        @Override
        public int compareTo(Delayed o) {
            if(this.getDelay(TimeUnit.MILLISECONDS)<o.getDelay(TimeUnit.MILLISECONDS)){
                return -1;
            } else if (this.getDelay(TimeUnit.MILLISECONDS)>o.getDelay(TimeUnit.MILLISECONDS)) {
                return 1;
            }
            return 0;
        }

        MyTask(long rt){
this.runningTime = rt;
        }
    }

}
