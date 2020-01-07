package com.xulk.mashibing.suanfa;

import java.util.Arrays;

/**
 * @description: 冒泡排序  时间复杂度n²，   最好时间复杂度 n， 空间复杂度 1， 稳定
 * <p>
 * 原理：第一个值跟第二个值比较，如果第 一个值比第二个值大，则交换位置，接着第二个值在跟第三个值比较，
 * 这样比较一轮之后，最后一个值就是就是整个数组当中最大的，然后再去比较出去最大值之后的剩余数据
 * <p>
 * 现状：时间复杂度和最好时间复杂度都是O(n²)
 * 优化：时间复杂度不变，最好时间复杂度可优化为O(n),优化的思路是针对已经拍好的顺序的数组没有必要接着判断继续进行排序操作
 * @author:
 * @create: 2019-11-09 23:26
 **/
public class BubbleSort {

    /**
     * @Description: 我写的这不叫冒泡排序  貌似时间复杂度也是O(n平方)
     * @Date: 2019/11/9  23:49
     */
    static void sort() {
        int[] arr = {1, 6, 2, 5, 2, 43, 52, 52, 2, 53, 54, 65423, 41, 243, 65, 7, 3, 6, 0};
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    swap(arr, i, j);
                }
            }
        }
        Arrays.stream(arr).forEach(System.out::println);
    }


    /**
     * @Description: 优化前的冒泡排序 最好时间复杂度为O(n²)
     * @Date: 2019/11/10  0:00
     */
    static void sort1() {
        int[] arr = {1, 6, 2, 5, 2, 43, 52, 52, 2, 53, 54, 65423, 41, 243, 65, 7, 3, 6, 0};
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
        Arrays.stream(arr).forEach(System.out::println);
    }


    /**
     * @Description: 优化后的冒泡排序 最好时间复杂度为O(n)
     * @Date: 2019/11/9  23:49
     */
    static void sort2() {
        int[] arr = {1, 6, 2, 5, 2, 43, 52, 52, 2, 53, 54, 65423, 41, 243, 65, 7, 3, 6, 0, 3};
        for (int i = 0; i < arr.length - 1; i++) {
            boolean didSwap = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] < arr[j + 1]) {
                    swap(arr, j, j + 1);
                    didSwap = true;
                }
            }
            if(!didSwap){
                //一次都没有交换位置的时候，说明是排好序的，可以直接结束，这时候的时间复杂度为O(n)
                return;
            }
        }
        Arrays.stream(arr).forEach(System.out::println);

    }


    //数组交换
    static void swap(int[] arr, int i, int j) {
        int temp = 0;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        sort1();
    }
}
