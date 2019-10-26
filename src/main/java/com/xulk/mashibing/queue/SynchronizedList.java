package com.xulk.mashibing.queue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by xulinkai on 2019/7/31.
 * Collections.synchronizedList(list);  返回的是一个加了锁的list
 */
public class SynchronizedList {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        List<String> asyncList = Collections.synchronizedList(list);
    }
}
