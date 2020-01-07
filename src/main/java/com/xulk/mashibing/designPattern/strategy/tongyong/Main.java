package com.xulk.mashibing.designPattern.strategy.tongyong;

/**
 * @description:
 * @author:
 * @create: 2019-08-28 21:49
 **/
public class Main {

    public static void main(String[] args) {
        IStrategy iStrategy = new StrategyA();
        Context context = new Context(iStrategy);
        context.algorithm();
    }
}
