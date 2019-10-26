package com.xulk.designPattern.mashibing.filter.v3;


/**
 * @description:
 * @author:
 * @create: 2019-09-03 23:30
 **/
public interface Filter {

    public boolean doFilter(Request request, Response response, FilterChain filterChain);
}
