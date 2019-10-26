package com.xulk.designPattern.mashibing.observer;

public interface Wechat {

    public void addObserver(Observer observer);

    public void deleteObserver(Observer observer);

    public void noticeObserver(String message);

    public String getName();

    public void setMessage(String message);


}
