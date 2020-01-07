package com.xulk.mashibing.designPattern.filter.v1;

/**
 * @description:
 * @author:
 * @create: 2019-09-01 22:25
 **/
public class OtherFilter implements Filter {
    @Override
    public boolean doFilter(Msg msg) {
        msg.setMsg(msg.getMsg().replace("许林凯","xulinkai"));
        return false;
    }
}
