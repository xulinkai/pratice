package com.xulk.designPattern.mashibing.observer;

/**
 * @description:
 * @author:
 * @create: 2019-09-05 22:01
 **/
public class Main {

    public static void main(String[] args) {
        Wechat wechat = new WechatImpl01("源码之家");
        Wechat wechat1 = new WechatImpl01("java核心");
        User user = new User("马云");
        User user2 = new User("马小二");
        User user5 = new User("马小五");
        User user6 = new User("马小六");
        wechat.addObserver(user);
        wechat.addObserver(user2);
        wechat.addObserver(user5);
        wechat1.addObserver(user6);
        wechat.setMessage("你若安好，便是晴天");
        wechat1.setMessage("天青色等烟雨");
        System.out.println("++++++++++++");
        wechat.deleteObserver(user2);
        wechat1.addObserver(user2);
        wechat.setMessage("我爱你，中国");
        wechat1.setMessage("晚安，北京");

    }
}
