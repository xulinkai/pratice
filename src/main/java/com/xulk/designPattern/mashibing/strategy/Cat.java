package com.xulk.designPattern.mashibing.strategy;

/**
 * @description:
 * @author:
 * @create: 2019-08-21 23:59
 **/
public class Cat implements Comparable<Cat>{

    public int weight;
    public int heigh;

    @Override
    public int compareTo(Cat cat) {
        if (this.weight < cat.weight) {
            return -1;
        } else if (this.weight > cat.weight) {
            return 1;
        }
        return 0;
    }



    public Cat(int weight, int heigh) {
        this.weight = weight;
        this.heigh = heigh;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "weight=" + weight +
                ", heigh=" + heigh +
                '}';
    }


}
