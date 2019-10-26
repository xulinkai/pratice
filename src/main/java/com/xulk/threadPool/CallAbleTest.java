package com.xulk.threadPool;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by xulinkai on 2019/7/21.
 * 实现callable接口去实现多线程
 * 缺点：创建线程的方式比较繁琐
 *
 */
public class CallAbleTest implements Callable<Integer>{


    @Override
    public Integer call() throws Exception {
        Thread.sleep(3000);
        return new Random().nextInt(10);
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CallAbleTest callable = new CallAbleTest();
        //启动线程  futureTask将callable任务包赚起来
        FutureTask<Integer> futureTask = new FutureTask<Integer>(callable);
        //在新的线程里面执行 callable的call任务
        Thread thread = new Thread(futureTask);
        thread.start();
        System.out.println(futureTask.isDone());//false
        //线程未执行完成之前，当前代码会等待
        System.out.println(futureTask.get());
        System.out.println(futureTask.isDone());//true


    }
}
