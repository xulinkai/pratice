package com.xulk.threadPool;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by xulinkai on 2019/7/21.
 */
public class CallableThreadPoolTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        List<Future> list = new ArrayList<>();
        for (int i = 0; i <100 ; i++) {
            Future<String> submit = executor.submit(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    Thread.sleep(3000);
                    return Thread.currentThread().getName();
                }
            });
            list.add(submit);
        }
        for (Future future:list) {
            System.out.println((String) future.get());
        }
        executor.shutdown();
    }
}
