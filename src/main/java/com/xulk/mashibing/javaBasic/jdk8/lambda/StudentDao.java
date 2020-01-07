package com.xulk.mashibing.javaBasic.jdk8.lambda;

/**
* @Description: @FunctionalInterface  标注函数式接口  可加可不加
* @Date: 2019/11/4  23:32
*/ 
@FunctionalInterface
public interface StudentDao {
    
    void add(Student student);
}
