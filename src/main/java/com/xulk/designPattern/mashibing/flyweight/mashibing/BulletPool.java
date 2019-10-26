package com.xulk.designPattern.mashibing.flyweight.mashibing;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author:
 * @create: 2019-09-07 00:43
 **/
public class BulletPool {

    List<Bullet> bullets = new ArrayList<>();

    {
        for (int i = 0; i < 5; i++) {
            bullets.add(new Bullet());
        }
    }
    
    public Bullet getBullet(){
        for (int i = 0; i < bullets.size(); i++) {
            Bullet bullet = bullets.get(i);
            if(!bullet.living){
                return bullet;
            }
        }
        return new Bullet();
    }
}
