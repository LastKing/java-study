package com.ltx.pattern.proxy.class1;

import java.util.Random;

/**
 * Created by toonew on 2017/1/20.
 */
public class Car implements Moveable {
    @Override
    public void move() {
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
