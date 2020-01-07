package com.xulk.mashibing.designPattern.flyweight.mashibing;

import java.util.UUID;

/**
 * @description:
 * @author:
 * @create: 2019-09-07 00:42
 **/
public class Bullet {

    public UUID id = UUID.randomUUID();

    boolean living = false;

    @Override
    public String toString() {
        return "Bullet{" +
                "id=" + id +
                ", living=" + living +
                '}';
    }
}
