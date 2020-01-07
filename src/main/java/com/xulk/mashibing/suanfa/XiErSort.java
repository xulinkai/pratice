package com.xulk.mashibing.suanfa;

import java.util.Arrays;

/**
 * @description: 希尔排序
 * 原理：取一个间隔，比如说间隔为4，先排1、5、9...位置上的
 * 再排2、6、10...位置上的
 * 间隔为4的时候排完之后，缩小间隔，直到间隔为1的时候，
 * 算是排序完毕
 * 希尔排序基于插入排序的
 * @author:
 * @create: 2019-11-11 21:25
 **/
public class XiErSort {

    static void sort() {
        int[] arr = {1, 6, 2, 5, 2, 43, 52, 52, 2, 53, 54, 65423, 41, 243, 65, 7, 3, 6, 0, 3};
        //初始间隔为数组的长度  每次间隔缩小一倍
        for (int gap = arr.length; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                for (int j = i; j > gap - 1; j -= gap) {
                    if (arr[j] < arr[j - 1]) {
                        swap(arr, j, j - 1);
                    }

                }

            }
        }
        Arrays.stream(arr).forEach(System.out::println);
        /*int gap = 4;//写的时候，可以先把固定间隔的情况写出来，再去考虑间隔一点一点缩小的情况
        for (int i = gap; i < arr.length; i++) {
            for (int j = i; j > gap - 1; j -= gap) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j - 1);
                }

            }

        }*/
    }

    /**
    * @Description: 间隔序列应该怎么定
     *             效率最高的间隔序列           h=1  h = 3*h+1;   1 4 7 10
    * @Date: 2019/11/11  22:01
    */
    static void sort1(){
        int[] arr = {1, 6, 2, 5, 2, 43, 52, 52, 2, 53, 54, 65423, 41, 243, 65, 7, 3, 6, 0, 3};
        int h = 1;
        while(h <= arr.length/3){
            h = h*3 + 1;
        }
        //初始间隔为数组的长度  每次间隔缩小一倍
        for (int gap = h; gap > 0; gap = (gap-1)/3) {
            for (int i = gap; i < arr.length; i++) {
                for (int j = i; j > gap - 1; j -= gap) {
                    if (arr[j] < arr[j - 1]) {
                        swap(arr, j, j - 1);
                    }

                }

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
        sort();

    }
}
