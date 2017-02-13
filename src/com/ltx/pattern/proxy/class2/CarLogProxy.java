package com.ltx.pattern.proxy.class2;

/**
 * Created by toonew on 2017/1/20.
 */
public class CarLogProxy implements Moveable {
    private Moveable m;

    public CarLogProxy(Moveable m) {
        this.m = m;
    }

    @Override
    public void move() {
        System.out.println("日志开始...");

        m.move();

        System.out.println("日志结束");
    }
}
