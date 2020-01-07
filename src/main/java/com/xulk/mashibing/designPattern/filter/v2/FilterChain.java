package com.xulk.mashibing.designPattern.filter.v2;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author:
 * @create: 2019-09-03 22:59
 **/
public class FilterChain implements Filter {

    List<Filter> filters = new ArrayList<>();

    int index = 0;

    public FilterChain add(Filter filter) {
        filters.add(filter);
        return this;
    }


    @Override
    public boolean doFilter(Request request, Response response, FilterChain filterChain) {
        if (index == filters.size()) {
            return false;
        }
        Filter filter = filters.get(index);
        index++;
        return filter.doFilter(request, response, filterChain);
    }
}
