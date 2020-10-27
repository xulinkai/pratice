package com.xulk.mashibing.jiaGouShi.gaoBingFa;

import java.util.ArrayList;
import java.util.List;

public class VolatileTest {

    volatile  int count = 0;

    public void m(){
        for (int i = 0; i < 10000; i++) {
            count++;
        }
    }

    public static void main(String[] args) {
        VolatileTest test = new VolatileTest();
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            threads.add(new Thread(test::m, "thread-"+i));
        }
        threads.forEach((thread -> thread.start()));
        System.out.println(test.count);

    }
}
