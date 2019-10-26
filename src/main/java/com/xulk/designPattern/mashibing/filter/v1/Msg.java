package com.xulk.designPattern.mashibing.filter.v1;

/**
 * @description:
 * @author:
 * @create: 2019-09-01 22:25
 **/
public class Msg {

    String name;

    String msg;

    @Override
    public String toString() {
        return "Msg{" +
                "msg='" + msg + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
