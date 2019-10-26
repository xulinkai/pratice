package com.xulk.designPattern.mashibing.filter.v3;


/**
 * @description:
 * @author:
 * @create: 2019-09-03 23:36
 **/
public class Main {

    public static void main(String[] args) {
        Request request = new Request();
        Response response = new Response();
        request.name = "大家好，我是<许林凯>，我不喜欢999，请多多指教";
        response.name = "大家好，我是<response>";
        FilterChain filterChain = new FilterChain();
        filterChain.add(new HtmlFilter());
        filterChain.add(new SensitiveFilter());
        filterChain.doFilter(request,response);
        System.out.println(request);
        System.out.println(response);
    }
}
