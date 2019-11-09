package com.xulk.javaBasic.jdk8.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @description:
 * @author:
 * @create: 2019-11-04 23:19
 **/
public class LambdaTest {

    static void test1() throws Exception {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("running.....");
            }
        };
        runnable.run();

        Runnable runnable1 = ()->{
            System.out.println("running.....");
        };
        runnable1.run();

        //方法体 只有一行的时候，{}可以省略 () 代表没有参数
        Runnable runnable2 = ()-> System.out.println("running.....");
        runnable2.run();


        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "null";
            }
        };
        callable.call();

        Callable<String> callable1 = ()->{return  "xulinkai";};
        callable1.call();

        Callable<String> callable2 = ()->"xulinkai";
        callable2.call();

        StudentDao dao = new StudentDao() {
            @Override
            public void add(Student student) {
                System.out.println("");
            }
        };

        StudentDao stu = (student)->{
            System.out.println("xxxxxxx");
        };

        StudentDao studentDao = (student)-> System.out.println("");


        TeacherDao teacherDao = new TeacherDao() {
            @Override
            public int get(Student student) {
                return 1;
            }
        };
        teacherDao.get(new Student());

        TeacherDao teacherDao1 = (student)->{return  1;};
        TeacherDao teacherDao3 = (Student student)->{return  1;};
        TeacherDao teacherDao2 = (student)->1;

    }

    /**
    * @Description:
     *              function 代表一个输入，一个输出 一般输入和输出是不同类型的
     *              unaryOperator 代表一个输入，一个输出，输入和输出是相同类型的
     *              bigFunction 代表两个输入 一个输出 一般输入和输出是不同类型的
     *              bigConsumer 代表两个输入
     *              binaryOperator 代表两个输入 一个输出  输入和输出是相同类型的
     *              supplier 代表一个输出·
     *              consumer 代表一个输入
     *
    * @Date: 2019/11/4  23:46
    */
    static void test2(){

        //定义一个function  第一个参数代表参数，第二个参数代表返回值
        //前面的function 用来接收后面的一个逻辑

        Function<String, Integer> function = (str)->{return str.length();};
        System.out.println(function.apply("xulinkai"));

        //Supplier  表示一个输出
        Supplier<String> stringSupplier = ()->{return  "xu";};
        stringSupplier.get();

        //consumer 表示一个输入
        Consumer<String> consumer = (string)->{
            System.out.println(string);
        };

        //方法调用
        Runnable runnable = ()->get();
        runnable.run();

        //biFunction 两个输入 一个输出
        BiFunction<String, String ,Integer> biFunction = (a,b)->a.length()+b.length();
        Integer apply = biFunction.apply("", "");
    }



    static int get(){
        System.out.println("get.......");
        return  1;
    }
    static  String find(){
        return  "xulinkai";
    }

    /**
    * @Description: lambda表达式之方法的引用
     * 方法引用时用来直接访问类或者实例的已经存在的方法或者构造方法，
     * 方法引用提供了一种引用而不执行方法的方式
     * 如果抽象方法的实现恰好可以使用调用另外一个方法来实现，就有可能可以使用方法引用
     * 静态方法引用：类名::staticMethod  （args） -> 类名.staticMethod(args)
     * 实例方法引用：inst::instMethod     (args) -> inst.instMethod(args)
     * 对象方法引用：类名::instMethod     (inst.args)->类名.instMethod(args)
     * 构造方法引用：类名::new            (args)->new 类名(args)
     *
     *
    * @Date: 2019/11/5  20:24
    */
    static void method(){

        List<String> list = Arrays.asList("d","c","b","a");
        list.forEach(System.out::println);

    }

    public static void main(String[] args) throws Exception {
        test2();
    }
}
