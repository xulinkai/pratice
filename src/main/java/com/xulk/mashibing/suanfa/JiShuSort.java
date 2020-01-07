package com.xulk.mashibing.suanfa;

import java.util.Arrays;

/**
 * @description: 计数排序（非比较排序） 桶思想的一种  使用场景（数据量特别大，但是数据的取值范围比较小）
 * 原理：数据范围可以枚举，枚举值的个数为m，定义一个长度为m的初始数组，数组每一个数值代表枚举值出现的个数，
 * @author:
 * @create: 2019-11-18 23:01
 **/
public class JiShuSort {

    static void start() {
        //取值范围是0-9
        int arr[] = {2, 4, 2, 3, 7, 1, 1, 4, 6, 3, 4, 7, 8, 0, 9, 5};
        int[] result = sort(arr);
        print(result);
    }

    //计数排序 不稳定
    static int[] sort(int[] arr) {
        int[] result = new int[arr.length];
        int count[] = new int[10];//可优化
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }
        System.out.println(Arrays.toString(count));
        for (int i = 0, j = 0; i < count.length; i++) {
            while (count[i]-- > 0) {
                result[j++] = i;
            }
        }
        return result;
    }


    //计数排序 稳定
    static int[] sort1(int[] arr) {
        int[] result = new int[arr.length];
        int count[] = new int[10];//可优化
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }
        System.out.println(Arrays.toString(count));
        for (int i = 1; i < count.length; i++) {
            count[i] = count[i] + count[i - 1];
        }
        for(int i = arr.length -1 ;i >= 0; i++){
            result[--count[arr[i]]] = arr[i];
        }
        return result;
    }

    //数组交换
    static void swap(int[] arr, int i, int j) {
        int temp = 0;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void print(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        //start();
        int count = 10;
        System.out.println((--count) > 9);
        System.out.println((count--) > 9);

    }
}
