package com.xulk.mashibing.javaBasic.jdk8.lambda;

import java.util.*;

/**
 * @description:
 * @author:
 * @create: 2019-11-04 21:46
 **/
public class Main {

    static void threadTest() {
        //写法1
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("running....");
            }
        });
        thread.start();
        //写法2
        new Thread(() -> {
            System.out.println("running.....");
        }).start();
    }

    static void compareTest() {
        //按照字符串长度排序
        //写法1
        List<String> list = Arrays.asList("java", "redis", "spring");
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        //写法2
        Collections.sort(list,(a,b)->a.length()-b.length());
        list.forEach(System.out::println);
    }


    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<Student>();
        list.add(new Student("xulinkai",12,99));
        list.add(new Student("xulinkai",14,88));
        list.add(new Student("xulinkai",15,21));
        list.add(new Student("xulinkai",16,45));
        list.add(new Student("xulinkai",17,78));
        list.add(new Student("xulinkai",18,85));
        //查询年龄大于12的学生

    }

    static void findByAge(ArrayList<Student> list){
        getByFilter(list, new AgeFilter());

        getByFilter(list, new StudentFilter() {
            @Override
            public boolean compare(Student student) {
                return student.getAge()>17;
            }
        });

        getByFilter(list, student -> student.getAge()>10);

    }

    static void findByScore(ArrayList<Student> list){

    }

    /**
    * @Description: 按成绩、年龄 只需要实现StudentFilter接口即可
    * @Date: 2019/11/4  22:17
    */
    static void getByFilter(ArrayList<Student> list, StudentFilter filter){
        List<Student> list1 = new ArrayList<>();
        for (Student student : list) {
            if(filter.compare(student)){
                list1.add(student);
            }
        }
    }
}
