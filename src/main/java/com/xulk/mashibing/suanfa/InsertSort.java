package com.xulk.mashibing.suanfa;

import java.util.Arrays;

/**
 * @description: 插入排序
 *
 * 原理：第二个值与第一个按要求的顺序进行比较，比较完之后，这两个值就是有顺序的，第三个值分别与前面这两个有顺序的数值相比较，
 *       如果它大于前一个数小于后一个数，那它就位于这两个数的中间，后面的数比较的时候，前面的那部分数组都=已经是有序的了
 *
 *       相当于一副乱序的扑克牌，拍好序 先前两张比，然后第三张跟前两张比，然后第四章跟前三张比
 * @author:
 * @create: 2019-11-10 00:25
 **/
public class InsertSort {


    static void sort(){
        int[] arr = {1, 6, 2, 5, 2, 43, 52, 52, 2, 53, 54, 65423, 41, 243, 65, 7, 3, 6, 0, 3};
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j>0; j--) {
                if(arr[j]<arr[j-1]){
                    swap(arr, j, j-1);
                }else {
                    break;
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
