package com.xulk.designPattern.mashibing.iterator;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @description:  手动写一个链表容器
 * @author:
 * @create: 2019-09-07 14:36
 **/
public class LinkList_ {


    Node head = null;//头结点
    Node tail = null;//尾节点
    private int size = 0;


    public void add(Object object){
        Node node = new Node(object);
        node.next = null;
        if(head == null){
            head = node;
            tail = node;
        }
        //node 追加到原来尾部的后面
        tail.next = node;
        //node成为新的尾部
        tail = node;
        size++;
    }

    public int size(){
        return size;
    }


    //内部类
    private class Node{
        //需要存放的真实对象
        private Object object;
        Node next;

        public Node(Object object) {
            this.object = object;
        }
    }
}


