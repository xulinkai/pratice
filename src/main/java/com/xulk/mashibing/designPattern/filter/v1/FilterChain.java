package com.xulk.mashibing.designPattern.filter.v1;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author:
 * @create: 2019-09-01 22:23
 **/
public class FilterChain implements Filter {

    List<Filter> filterChain = new ArrayList<>();

    public FilterChain add(Filter filter){
        filterChain.add(filter);
        return this;
    }
    @Override
    public boolean doFilter(Msg msg) {
        for (Filter filter : filterChain) {
            if(!filter.doFilter(msg)){
                return false;
            };
        }
        return true;
    }
}
