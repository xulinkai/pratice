package com.xulk.mashibing.threadPool;

import java.util.concurrent.*;

/**
 * Created by xulinkai on 2019/8/7.
 * FutureTask 包装了一个任务（实现Callabler接口的任务，可以通过get()方法获取返回值）
 */
public class Future_test {


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<Integer>(() -> {
            TimeUnit.SECONDS.sleep(5);
            return 1000;
        });
        new Thread(futureTask).start();
        //get()方法会阻塞在这里
        System.out.println(futureTask.get());

        ExecutorService service = Executors.newFixedThreadPool(5);
        //
        Future<Integer> task = service.submit(() -> {
            TimeUnit.SECONDS.sleep(1);
            return 10;
        });
        System.out.println(task.isDone());
        System.out.println(task.get());
        System.out.println(task.isDone());


    }
}
