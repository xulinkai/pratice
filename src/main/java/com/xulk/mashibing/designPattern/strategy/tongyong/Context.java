package com.xulk.mashibing.designPattern.strategy.tongyong;

/**
 * @description:
 * @author:
 * @create: 2019-08-28 21:46
 **/
public class Context {

    private IStrategy iStrategy;

    public void algorithm(){
        iStrategy.algorithm();
    }

    public Context(IStrategy iStrategy) {
        this.iStrategy = iStrategy;
    }
}
