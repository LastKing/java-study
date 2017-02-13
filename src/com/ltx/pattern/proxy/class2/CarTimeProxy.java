package com.ltx.pattern.proxy.class2;

/**
 * Created by toonew on 2017/1/20.
 */
public class CarTimeProxy implements Moveable {
    private Moveable m;

    public CarTimeProxy(Moveable m) {
        this.m = m;
    }

    @Override
    public void move() {
        long startTime = System.currentTimeMillis();

        System.out.println("汽车开始形式...");

        m.move();


        long endTime = System.currentTimeMillis();
        System.out.println("汽车move 结束，行驶时间：" + (endTime - startTime) + "毫秒！");
    }
}
