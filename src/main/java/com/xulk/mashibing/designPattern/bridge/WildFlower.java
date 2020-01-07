package com.xulk.mashibing.designPattern.bridge;

/**
 * @description:
 * @author:
 * @create: 2019-09-08 01:49
 **/
public class WildFlower extends Gift {

    public WildFlower(GiftImpl giftImpl) {
        this.giftImpl = giftImpl;
    }
}
