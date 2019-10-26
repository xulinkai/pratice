package com.xulk.designPattern.mashibing.filter.v2;

import com.xulk.designPattern.mashibing.filter.v1.Msg;

/**
 * @description:
 * @author:
 * @create: 2019-09-01 22:25
 **/
public class HtmlFilter implements Filter {

    @Override
    public boolean doFilter(Request request, Response response, FilterChain filterChain) {
        request.name = request.name.replaceAll("<","[")+"-htmlFilter";
        filterChain.doFilter(request,response,filterChain);
        response.name += "-htmlFilter";
        return true;
    }
}
