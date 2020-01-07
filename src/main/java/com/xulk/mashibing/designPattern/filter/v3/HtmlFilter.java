package com.xulk.mashibing.designPattern.filter.v3;


/**
 * @description:
 * @author:
 * @create: 2019-09-01 22:25
 **/
public class HtmlFilter implements Filter {

    @Override
    public boolean doFilter(Request request, Response response, FilterChain filterChain) {
        request.name = request.name.replaceAll("<","[")+"-htmlFilter";
        filterChain.doFilter(request,response);
        response.name += "-htmlFilter";
        return true;
    }
}
