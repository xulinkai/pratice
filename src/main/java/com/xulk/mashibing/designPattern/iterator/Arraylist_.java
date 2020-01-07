package com.xulk.mashibing.designPattern.iterator;

import java.util.ArrayList;

/**
 * @description: 手动写一个容器，相比于数组，这个容器不用考虑边界问题，可以动态扩展
 * @author:
 * @create: 2019-09-07 14:27
 **/
public class Arraylist_ implements Collection_ {

    Object[] objects = new Object[10];
    //下一个空的位置在哪 或者说 目前容器中有多少元素
    private int index = 0;

    public void add(Object object) {
        if (index == objects.length) {
            Object[] newObjects = new Object[objects.length * 2];
            System.arraycopy(objects, 0, newObjects, 0, objects.length);
            objects = newObjects;
        }
        objects[index] = object;
        index++;
    }

    @Override
    public int size() {
        return size();
    }

    @Override
    public Iterator_ iterator_() {
        return new ArraylistIterator_();
    }

    private class ArraylistIterator_ implements Iterator_ {

        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            if (currentIndex >= index) {
                return false;
            }
            return true;
        }

        @Override
        public Object next() {
            Object object = objects[currentIndex];
            currentIndex++;
            return object;
        }

        public  void main(String[] args) {
            ArrayList<Object> list = new ArrayList<>();
            list.iterator();
        }
    }

}
