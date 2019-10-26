package com.xulk.mashibing.threadPool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by xulinkai on 2019/8/7.
 * 并行计算
 *
 * 57分钟
 */
public class ParalleComputing {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
        List<Integer> results = getPrime(1,200000);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        final int cpuCoreNum = 4;
        ExecutorService service = Executors.newFixedThreadPool(cpuCoreNum);
        MyTask task1 = new MyTask(1, 80000);
        MyTask task2 = new MyTask(80001, 160000);
        MyTask task3 = new MyTask(160001, 200000);
        Future<List<Integer>> submit1 = service.submit(task1);
        Future<List<Integer>> submit2 = service.submit(task2);
        Future<List<Integer>> submit3 = service.submit(task3);
        long starts = System.currentTimeMillis();
        List<Integer> integers = submit1.get();
        List<Integer> integers1 = submit2.get();
        List<Integer> integers2 = submit3.get();
        long ends = System.currentTimeMillis();
        System.out.println(ends - starts);


    }

    static class MyTask implements Callable<List<Integer>> {
        int startPos;
        int endPos;

        public MyTask(int startPos, int endPos) {
            this.startPos = startPos;
            this.endPos = endPos;
        }

        @Override
        public List<Integer> call() throws Exception {
            List<Integer> prime = getPrime(this.startPos, this.endPos);
            return prime;
        }
    }

    static boolean isPrime(Integer integer) {
        for (int i = 2; i <= integer / 2; i++) {
            if (integer % i == 0) {
                return false;
            }
        }
        return true;
    }

    static List<Integer> getPrime(int start,int end){
        List<Integer> list = new ArrayList<>();
        for (int i = start; i <=end ; i++) {
            if(isPrime(i)){
                list.add(i);
            }
        }
        return  list;
    }
}


