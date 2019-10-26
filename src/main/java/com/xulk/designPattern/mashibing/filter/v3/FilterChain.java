package com.xulk.designPattern.mashibing.filter.v3;


import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author:
 * @create: 2019-09-03 22:59
 **/
public class FilterChain  {

    List<Filter> filters = new ArrayList<>();

    int index = 0;

    public FilterChain add(Filter filter) {
        filters.add(filter);
        return this;
    }


    public boolean doFilter(Request request, Response response) {
        if (index == filters.size()) {
            return false;
        }
        Filter filter = filters.get(index);
        index++;
        return filter.doFilter(request, response, this);
    }
}
