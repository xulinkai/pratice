package com.xulk.designPattern.mashibing.filter.v1;

/**
 * @description:
 * @author:
 * @create: 2019-09-01 22:25
 **/
public class SensitiveFilter implements Filter {
    @Override
    public boolean doFilter(Msg msg) {
        msg.setMsg(msg.getMsg().replace("999","888"));
        return true;
    }
}
