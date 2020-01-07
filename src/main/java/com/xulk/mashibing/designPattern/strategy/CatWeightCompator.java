package com.xulk.mashibing.designPattern.strategy;

/**
 * @description:
 * @author:
 * @create: 2019-08-22 23:33
 **/
public class CatWeightCompator implements Comparator<Cat> {


    @Override
    public int compareTo(Cat cat, Cat t1) {
        if (cat.weight < t1.weight) {
            return -1;
        } else if (cat.weight > t1.weight) {
            return 1;
        }
        return 0;
    }
}
