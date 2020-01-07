package com.xulk.mashibing.suanfa;

import java.util.Arrays;

/**
 * @description: 基数排序
 * <p>
 * 原理：先排个位、再排十位、依次往后
 * @author:
 * @create: 2019-11-20 21:31
 **/
public class JisuSort {

    static void sort(int[] arr) {
        int[] result = new int[arr.length];
        int[] count = new int[10];
        for (int i = 0; i < 3; i++) {
            int division = (int) Math.pow(10, i);
            for (int i1 = 0; i1 < arr.length; i1++) {
                int num = arr[i1] / division % 10;
                count[num]++;
            }
            for (int m = 1; m < count.length; m++) {
                count[m] = count[m] + count[m - 1];
            }

            for (int n = arr.length - 1; n >= 0; n--) {
                int num = arr[n] / division % 10;
                result[--count[num]] = arr[n];
            }
            System.arraycopy(result, 0, arr, 0, arr.length);
            Arrays.fill(count, 0);
        }

    }


}
