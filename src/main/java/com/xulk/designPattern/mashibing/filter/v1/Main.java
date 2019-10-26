package com.xulk.designPattern.mashibing.filter.v1;

/**
 * @description:
 * @author:
 * @create: 2019-09-01 22:28
 **/
public class Main {

    public static void main(String[] args) {
        String msg = "大家好，我是<许林凯>，我不喜欢999，你是不是也一样";
        Msg msg1 = new Msg();
        msg1.setMsg(msg);

        FilterChain filterChain = new FilterChain();
        filterChain.add(new HtmlFilter()).add(new OtherFilter());

        FilterChain1 filterChain1 = new FilterChain1();
        filterChain1.add(new SensitiveFilter());

        filterChain.add(filterChain1);

        filterChain.doFilter(msg1);

        System.out.println(msg1);


    }
}
