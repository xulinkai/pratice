package com.xulk.mashibing.javaBasic.jdk8.lambda;


@FunctionalInterface
public interface StudentFilter {

    boolean compare(Student student);
}
