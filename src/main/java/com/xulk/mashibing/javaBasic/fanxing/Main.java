package com.xulk.mashibing.javaBasic.fanxing;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @description:  泛型的使用:  解决存储元素的安全性问题
 *                声明泛型类
 *                声明泛型方法
 *
 *
 * @author:
 * @create: 2019-11-03 21:29
 **/
public class Main implements FanxingInterface<String> {


    /**
    * @Description: 在集合中没有使用泛型的情况
    * @Param:
    * @return:
    * @Date: 2019/11/3  21:31
    */
    public void test(){
        //public interface List<E> extends Collection<E>   list的源码会直接指定泛型
        List list = new ArrayList();
        list.add(10);
        list.add("fd");
    }



    /**
    * @Description: 所有使用到E的地方，都改为当前类操作传进去的对象
    * @Param:
    * @return:
    * @Date: 2019/11/3  21:52
    */
    @Override
    public void test(String s) {

    }
    
    
    /** 
    * @Description: 声明一个泛型方法  有返回值
    * @Param:  
    * @return: 
    * @Date: 2019/11/3  22:01
    */ 
    public <E> E getE(E e){
        return  e;
    }

    /**
    * @Description:    声明一个泛型方法 无返回值
    * @Param:
    * @return:
    * @Date: 2019/11/3  22:04
    */
    public <E> void test1(E[] e,List<E> list){
        System.out.println();
    }

    /**
    * @Description: ?通配符的使用
    * @Param:
    * @return:
    * @Date: 2019/11/3  22:15
    */
    public void test2(){
        List<?> list = null;
        List<Object> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        list = list1;
        list = list2;

        // 可以读取声明为通配符的集合类的对象
        Iterator<?> iterator = list.iterator();

        //list1 = list2; 会报错
        //list2 = list1; 会报错

    }
    
    
}
