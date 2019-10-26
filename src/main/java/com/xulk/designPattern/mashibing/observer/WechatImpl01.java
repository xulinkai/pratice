package com.xulk.designPattern.mashibing.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author:
 * @create: 2019-09-05 21:58
 **/
public class WechatImpl01 implements Wechat {

    private String name;

    private String message;

    @Override
    public void setMessage(String message) {
        this.message = message;
        noticeObserver(message);
    }

    public WechatImpl01(String name) {
        this.name = name;
    }

    private List<Observer> observerList = new ArrayList<>();

    @Override
    public void addObserver(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void deleteObserver(Observer observer) {
        if(observerList.indexOf(observer)>=0){
            observerList.remove(observer);
        }
    }

    @Override
    public void noticeObserver(String message) {
        for (Observer observer : observerList) {
            observer.receive(this,message);
        }
    }

    @Override
    public String getName() {
        return this.name;
    }
}
