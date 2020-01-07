package com.xulk.mashibing.designPattern.strategy;

import java.util.Arrays;

/**
 * @description:
 * @author:
 * @create: 2019-08-21 23:43
 **/
public class Main {

    public static void main(String[] args) {
        int[] arr = {8,2,6,3,5,7,9,0};
        Cat[] cats = {new Cat(3,3),new Cat(2,2),new Cat(5,5)};
        Sorter sorter = new Sorter();
        sorter.sort(arr);
        //sorter.sortCat(cats);

        //将当前比较策略传进去，
        Sorter<Cat> sorter1 = new Sorter<Cat>();
        sorter1.sort(cats,new CatWeightCompator());
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(cats));

    }
}
