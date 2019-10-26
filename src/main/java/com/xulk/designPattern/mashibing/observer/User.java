package com.xulk.designPattern.mashibing.observer;

/**
 * @description:   message 不一定是发布了一条消息，也可以是一个封装好的时间，obserber可以根据事件类型做相应的处理
 * @author:
 * @create: 2019-09-05 21:49
 **/
public class User implements Observer {

    private String name;

    public User(String name) {
        this.name = name;
    }

    @Override
    public void receive(Wechat wechat,String message) {
        System.out.println(this.name+"收听了："+wechat.getName()+"发布的："+message);
    }
}
