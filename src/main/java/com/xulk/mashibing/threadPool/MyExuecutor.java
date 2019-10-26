package com.xulk.mashibing.threadPool;

import java.util.concurrent.Executor;

/**
 * Created by xulinkai on 2019/8/7.
 */
public class MyExuecutor implements Executor {


    @Override
    public void execute(Runnable command) {
        new Thread(command).start();
        //command.run();
    }

    public static void main(String[] args) {
        new MyExuecutor().execute(()->{
            System.out.println("Hello world!");
        });
    }
}
