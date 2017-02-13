package com.ltx.pattern.proxy.class1;

/**
 * Created by toonew on 2017/1/20.
 */
public class Car2 extends Car {
    @Override
    public void move() {
        long startTime = System.currentTimeMillis();

        System.out.println("汽车开始形式...");

        super.move();

        long endTime = System.currentTimeMillis();
        System.out.println("汽车move 结束，行驶时间：" + (endTime - startTime) + "毫秒！");
    }
}
