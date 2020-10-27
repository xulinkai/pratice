package com.xulk.mashibing.springSourceCode;

import sun.net.util.IPAddressUtil;

import java.util.stream.Stream;

/**
 * @description:  spring 源码核心源码逻辑
 *  spring本身给出了扩展：
 *                      a、在创建对象之前可以做一点事
 *                      b、容器初始化之前可以干一点事
 *                      c、在不同的阶段发出不同的事件，你还可以干一点事
 *                      d、抽象出各个接口，让你为所欲为
 *                      e、面向接口编程
 **/
public class DemoTest {

    public static void main(String[] args) {
        UserController userController = new UserController();
        Class<? extends UserController> aClass = userController.getClass();
        UserService userService = new UserService();
        Stream.of(aClass.getDeclaredFields()).forEach(field -> {
            String name = field.getName();
            System.out.println(name);
            MyAutowired annotation = field.getAnnotation(MyAutowired.class);
            if(annotation != null){
                field.setAccessible(true);
                Class<?> type = field.getType();
                try {
                    Object o = type.newInstance();
                    field.set(userController, o);
                    System.out.println(userController.getUserService());
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
