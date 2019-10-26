package com.xulk.mashibing.threadPool;

import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

/**
 * Created by xulinkai on 2019/8/8.
 */
public class ForkJoinPool_test {

    static int[] nums = new int[1000000];
    static final int MAX_NUM = 50000;
    static Random random = new Random();

    static {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = random.nextInt(100);
        }
        System.out.println(Arrays.stream(nums).sum());
    }

    //没有返回值  相当于runnable
    static class AddTask extends RecursiveAction {
        int start, end;

        AddTask(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        protected void compute() {
            if (end - start <= MAX_NUM) {
                long sum = 0L;
                for (int i = start; i < end; i++) {
                    sum += nums[i];
                }
                System.out.println("from:"+start+" to "+end+" sum "+sum );
            } else {
                int middle = start+(end-start)/2;
                AddTask task1= new AddTask(start,middle);
                AddTask task2 = new AddTask(middle,end);
                task1.fork();//只要fork 肯定有新的线程启动
                task2.fork();
            }

        }

    }

    //有返回值  相当于callable
    /*static class AddTask extends RecursiveTask<Long> {
        int start, end;

        AddTask(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        protected Long compute() {
            if (end - start <= MAX_NUM) {
                long sum = 0L;
                for (int i = start; i < end; i++) {
                    sum += nums[i];
                }
                return sum;
            }
            int middle = start+(end-start)/2;
            AddTask task1= new AddTask(start,middle);
            AddTask task2 = new AddTask(middle,end);
            task1.fork();//只要fork 肯定有新的线程启动
            task2.fork();
            return task1.join()+task2.join();
        }

    }*/
    public static void main(String[] args) throws IOException {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        AddTask addTask = new AddTask(0,nums.length);
        forkJoinPool.execute(addTask);
//        long result = addTask.join();
//        System.out.println(result);
        //forkJoinPoll 也是精灵线程，需要使用System进行阻塞
        System.in.read();

    }
}
