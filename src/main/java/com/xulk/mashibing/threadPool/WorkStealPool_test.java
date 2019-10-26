package com.xulk.mashibing.threadPool;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by xulinkai on 2019/8/8.
 * WorkStealingPool 每一个线程单独维护一个自己的任务队列，
 * 当自己的任务队列执行完成的时候会从其他线程维护的队列当中窃取任务加以执行
 */
public class WorkStealPool_test {

    public static void main(String[] args) throws IOException {
        //根据cpu几核默认开启几个线程
        ExecutorService service = Executors.newWorkStealingPool();
        //打印当前cpu是几核
        System.out.println(Runtime.getRuntime().availableProcessors());
        //八核开启八个线程，最后一个任务又会重新被第一个线程执行
        service.execute(new R(1000));
        service.execute(new R(2000));
        service.execute(new R(2000));
        service.execute(new R(2000));
        service.execute(new R(2000));
        service.execute(new R(2000));
        service.execute(new R(2000));
        service.execute(new R(2000));
        service.execute(new R(2000));
        //由于产生的是精灵线程（守护线程、后台线程）主线程不阻塞的话，看不到输出
        System.in.read();

    }

    static class R implements Runnable{
        int time ;

        public R(int time) {
            this.time = time;
        }

        @Override
        public void run() {
            try {
                TimeUnit.MILLISECONDS.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(time+"_"+Thread.currentThread().getName());
        }
    }
}
