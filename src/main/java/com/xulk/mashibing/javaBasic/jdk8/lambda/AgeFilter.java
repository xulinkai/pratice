package com.xulk.mashibing.javaBasic.jdk8.lambda;

/**
 * @description:
 * @author:
 * @create: 2019-11-04 22:13
 **/
public class AgeFilter implements StudentFilter {
    @Override
    public boolean compare(Student student) {
        return student.getAge()>14;
    }
}
