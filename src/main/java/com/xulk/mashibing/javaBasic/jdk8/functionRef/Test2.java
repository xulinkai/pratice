package com.xulk.mashibing.javaBasic.jdk8.functionRef;

/**
 * @description:
 * @author:
 * @create: 2019-11-05 21:41
 **/

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @Description: function 代表一个输入，一个输出 一般输入和输出是不同类型的
 * unaryOperator 代表一个输入，一个输出，输入和输出是相同类型的
 * bigFunction 代表两个输入 一个输出 一般输入和输出是不同类型的
 * bigConsumer 代表两个输入
 * binaryOperator 代表两个输入 一个输出  输入和输出是相同类型的
 * supplier 代表一个输出·
 * consumer 代表一个输入
 * @Date: 2019/11/4  23:46
 */
public class Test2 {

    static String put() {
        System.out.println("put");
        return "put";
    }

    static void getInt(int s) {
        System.out.println(s);
    }

    static String getString(String str) {
        return str.toUpperCase();
    }

    public static void main(String[] args) {

    }

    String put1() {
        return "put";
    }

    /**
     * @Description: 静态方法的引用
     * @Date: 2019/11/5  23:01
     */
    public void method() {
        //调用方式1
        System.out.println(put());

        //调用方式2
        Supplier<String> stringSupplier = () -> Test2.put();
        System.out.println(stringSupplier.get());

        //调用方式3
        Supplier<String> supplier = Test2::put;
        System.out.println(supplier.get());

        //调用方式4
        Supplier<String> supplier1 = Fun::hehe;
        System.out.println(supplier1.get());

        //调用方式5
        Consumer<Integer> consumer = Test2::getInt;
        Consumer<Integer> consumer1 = (size) -> Test2.getInt(size);
        consumer.accept(121);

        //调用方式6
        Function<String, String> function = (str) -> {return getString(str);};
        function = (str) -> Test2.getString(str);
        function = Test2::getString;
        String abc = function.apply("abc");
    }

    void get(int in) {
        System.out.println(in);
    }

    String returnString(String s){
        return  s.toUpperCase();
    }

    /**
     * @Description: 实例方法的引用
     * @Date: 2019/11/5  23:02
     */
    public void method1() {
        //方法调用1
        Supplier<String> supplier = () -> new Test2().put1();
        supplier = () -> {
            return new Test2().put1();
        };
        supplier = new Test2()::put1;
        System.out.println(supplier.get());

        //方法调用2
        Consumer<Integer> consumer = (size)->new Test2().get(size);
        consumer = new Test2()::get;
        consumer.accept(21);

        //方法调用3
        Function<String, String> function = (str)->new Test2().returnString(str);
        function = (str)->new Test2().returnString(str);
        function = new Test2()::returnString;
        String xulinkai = function.apply("xulinkai");
    }

    /**
    * @Description: 构造方法的引用
    * @Date: 2019/11/5  23:18
    */
    public void method3(){
        Supplier<Person> supplier = ()->new Person();
        supplier = Person::new;
        supplier.get();

        Supplier<List> supplier1 = ArrayList::new;

        Consumer<Integer> consumer = (age)->new Account(age);
        consumer = Account::new;
        consumer.accept(3232);

        Function<String , Account> function = (str)->new Account(str);
        function = Account::new;
        function.apply("xulinkai");

    }
}

class Person{
    Person(){}
}

class Account{
    Account(){
        System.out.println("调用无参构造account");
    }

    Account(int age){
        System.out.println("调用有参构造。。");
    }

    Account(String str){
        System.out.println("str");
    }

}

class Fun {
    static String hehe() {
        return "hehe";
    }

    static String toUpperCase(String string) {
        return string.toUpperCase();
    }

    Integer fun(String string){
        return 1;
    }

    void foo(){
        System.out.println("foo");
    }
}


