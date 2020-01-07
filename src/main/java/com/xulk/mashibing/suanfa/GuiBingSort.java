package com.xulk.mashibing.suanfa;

import java.util.Arrays;

/**
 * @description: 归并排序
 * <p>
 * 原理：
 * 一个大的数组，分成两个小的数组，每个小的数组在分成更小的两个数组，
 * 最小的数组排序好之后，跟它同级的小数组进行合并，依次类推
 * 核心： 对两个有序的数组进行合并
 * 思想：数组一 长度4
 * 数组二 长度4
 * 定义一个长度为8的数组，数组1跟数组2的第一位相比，小的放前面
 * 然后另一数组的第二位跟剩下较大那个数组的第一位进行比较，较小的放在大数组的第二位，依次类推
 * @author:
 * @create: 2019-11-11 22:48
 **/
public class GuiBingSort {


    /**
     * @Description: arr是一个数组，前半部分和后半部分已经排好序
     * 目标：合并成一个有序数组
     * @Date: 2019/11/11  23:04
     */
    static void merge(int[] arrr) {
        int[] arr = {1, 3, 5, 7, 2, 4, 6, 8};
        //中间位置
        int mid = arr.length / 2;
        //临时数组
        int[] temp = new int[arr.length];
        int i = 0;//指向前半部分数组的第一位
        int j = mid;//指向后半部分数组第一位
        int k = 0;//指向临时数组第一位
        while (i < mid && j < arr.length) {
            if (arr[i] <= arr[j]) {
                temp[k] = arr[i];
                k++;
                i++;
            } else {
                temp[k] = arr[j];
                k++;
                j++;
            }
        }
        //上面的循环跳出之后，肯定有且只有一方的数组是有剩余的
        while (i < mid) {
            temp[k++] = arr[i++];
        }
        while (j < arr.length) {
            temp[k++] = arr[j++];
        }
        Arrays.stream(temp).forEach(System.out::println);

    }


    /**
     * @Description: 左半数组开始下标  右半数组开始下边  右半数组边界位置
     * @Date: 2019/11/11  23:20
     */
    static void merge(int[] arr, int leftPtr, int rightPtr, int rightBound) {
        //中间位置
        int mid = rightPtr - 1;
        //临时数组
        int[] temp = new int[rightBound - leftPtr + 1];
        int i = leftPtr;//指向前半部分数组的第一位
        int j = rightPtr;//指向后半部分数组第一位
        int k = 0;//指向临时数组第一位
        while (i <= mid && j < rightBound) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        //上面的循环跳出之后，肯定有且只有一方的数组是有剩余的
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= rightBound) {
            temp[k++] = arr[j++];
        }
        //临时数组的值赋给arr
        for (int i1 = 0; i1 < temp.length; i1++) {
            arr[i1 + leftPtr] = temp[i1];
        }
    }

    static void sort(int[] arr, int left, int right) {
        if (left == right) {
            return;
        }
        //分成两半
        int mid = left + (right - left) / 2;
        //左边排序
        sort(arr, left, mid);
        //右边排序
        sort(arr, mid + 1, right);
        //合并
        merge(arr, left, mid + 1, right);
    }

    /**
     * @Description: 对两个已经排好顺序的数组进行重新排序
     * @Date: 2019/11/12  23:38
     */
    static void sortTest(int[] arr1, int[] arr2) {
        int[] arr = new int[arr1.length + arr2.length];
        int index1 = 0;
        int index2 = 0;
        int index = 0;
        while (index1 < arr1.length && index2 < arr2.length) {
            if (arr1[index1] > arr2[index2]) {
                arr[index++] = arr2[index2++];
            } else {
                arr[index++] = arr1[index1++];
            }
        }
        //上面比较完毕之后，肯定有一个数组是还有数据的，而且数据有序
        while (index1 < arr1.length) {
            arr[index++] = arr1[index1++];
        }
        while (index2 < arr2.length) {
            arr[index++] = arr2[index2++];
        }
        Arrays.stream(arr).forEach(System.out::println);
    }

    public static void main(String[] args) {

        int[] arr = {1, 6, 12, 15, 21, 43, 52};
        int[] array = {1, 3, 5, 7, 2, 4, 6, 8, 99, 102};
        sortTest(arr, array);

    }
}
