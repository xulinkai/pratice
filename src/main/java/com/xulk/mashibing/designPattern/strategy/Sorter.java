package com.xulk.mashibing.designPattern.strategy;

/**
 * @description:
 * @author:
 * @create: 2019-08-21 23:38
 **/
public class Sorter<T> {

    /** 
    * @Description: 选择排序
    * @Param:  
    * @return: 
    * @Date: 2019/8/21  23:59
    */ 
    public static void sort(int[] arrs) {
        for (int i = 0; i < arrs.length - 1; i++) {
            int minPos = i;
            for (int j = i + 1; j < arrs.length; j++) {
                minPos = arrs[j] < arrs[minPos] ? j : minPos;
            }
            swap(arrs,i,minPos);
        }

    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }

    /** 
    * @Description: 传进来的都是实现了Comparable接口的对象数组 
    * @Param:  
    * @return: 
    * @Date: 2019/8/22  23:32
    */ 
    public static void sortCat(Comparable[] arrs) {
        for (int i = 0; i < arrs.length - 1; i++) {
            int minPos = i;
            for (int j = i + 1; j < arrs.length; j++) {
                minPos = arrs[j].compareTo(arrs[minPos]) ==-1  ? j : minPos;
            }
            swap(arrs,i,minPos);
        }
    }

    public static void swap(Comparable[] arr, int i, int j) {
        Comparable temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
    * @Description:    比较的数组对象传进来，比较策略也传进来
    * @Param:
    * @return:
    * @Date: 2019/8/22  23:36
    */
    public  void sort(T[] arrs, Comparator comparator) {
        for (int i = 0; i < arrs.length - 1; i++) {
            int minPos = i;
            for (int j = i + 1; j < arrs.length; j++) {
                minPos = comparator.compareTo(arrs[j],arrs[minPos]) ==-1  ? j : minPos;
            }
            swa(arrs,i,minPos);
        }
    }

    public  void swa(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}
