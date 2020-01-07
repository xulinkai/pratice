package com.xulk.mashibing.suanfa;

import java.util.Arrays;

/**
 * @description: 选择排序  时间复杂度O(n²) 空间复杂度 1 （不占用额外空间）， 不稳定  时间复杂度主要是在for循环的内循环的里面
 * 最简单、最没用
 * 不稳定：主要体现在两个相等的数据在排序完成之后，这两个相等的数据相对顺序发生了变化
 * 原理：一遍一遍过滤数组，先找到最小的，放到最前面（最前面与最小值交换位置），再过滤除第一个元素之外的最小值
 * 寻找最小值得过程：第一个跟第二个比，选出较小值，下标指向较小值，较小值跟第三个比，比之后，下标依然指向较小值，
 * 也就是说当前下标指向的较小值，较小值跟下一元素比较，得到结果之后，下标调整依然指向较小值
 * 交换位置只发生在 过滤整个数组某一遍完成的时候
 * <p>
 * <p>
 * 选择排序心得： 内循环：定义变量最小值下标，并筛选数组获取最小值下标
 * 外循环：最小值与第一个值交换
 * 现状：比较一遍，找出最小值
 * 优化：比较一遍，找出最小值，和最大值，最小值放最前面，最大值放最后面，少循环一半的次数
 * @author:
 * @create: 2019-11-09 21:09
 **/
public class SelectionSort {


    public static void main(String[] args) {
        int[] arr = {1, 6, 2, 5, 2, 43, 52, 52, 2, 53, 54, 65423, 41, 243, 65, 7, 3, 6, 0};
        //因为内层for循环 j=i+1; 所以这里写 i<arr.length-1就可以 少循环一次，但是写i<arr.length也不算错
        //交换只发生在某一轮确定最小值小标的时候
        for (int i = 0; i < arr.length - 1; i++) {
            //定义最小值下标
            int minPos = i;
            for (int j = i + 1; j < arr.length; j++) {
                minPos = arr[j] < arr[minPos] ? j : minPos;
            }
            swap(arr, i, minPos);
        }
        Arrays.stream(arr).forEach(System.out::println);

    }

    //数组交换
    static void swap(int[] arr, int i, int j){
        int temp = 0;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
