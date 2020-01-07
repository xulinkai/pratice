package com.xulk.mashibing.designPattern.filter.v2;

/**
 * @description:
 * @author:
 * @create: 2019-09-03 22:58
 **/
public interface Filter {

    public boolean doFilter(Request request, Response response, FilterChain filterChain);
}
