package com.xulk.threadMonitor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by xulinkai on 2019/7/25.
 */
public class ThreadTest {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        ThreadApplication threadApplication = new ThreadApplication(executorService);
        threadApplication.run();
    }
}
