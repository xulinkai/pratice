package com.xulk.mashibing.suanfa;

/**
 * @description: 快速排序：
 * <p>
 * 原理：中间找一个轴，比轴大的放到右边，比轴小的放在左边，然后利用递归进行重复找轴的过程
 * 先分区，再进行排序
 * @author:
 * @create: 2019-11-18 21:32
 **/
public class KuaiSuSort {


    static void start() {
        int[] arr = {1, 6, 2, 5, 2, 43, 52, 52, 2, 53, 54, 65423, 41, 243, 65, 7, 3, 6, 50};
        sort(arr, 0, arr.length - 1);
        print(arr);
    }

    static void sort(int[] arr, int leftBound, int rightBound) {
        if (leftBound >= rightBound) {
            return;
        }
        //轴的位置
        int partition = partition(arr, leftBound, rightBound);
        sort(arr, leftBound, partition-1);
        sort(arr, partition+1, rightBound);
    }

    /**
     * @Description: 分区
     * @Date: 2019/11/18  21:44
     */
    static int partition(int[] arr, int leftRound, int rightBound) {
        int pivot = arr[rightBound];//轴
        int left = leftRound;
        int right = rightBound - 1;
        while (left <= right) {
            while (left <= right && arr[left] <= pivot) {
                left++;
            }
            while (left <= right && arr[right] > pivot) {
                right--;
            }
            if (left < right) {
                swap(arr, left, right);
            }
        }

        //交换轴的位置  轴此时位于left的位置
        swap(arr, left, rightBound);
        //返回轴的位置
        return left;


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
        start();

    }
}
