package com.ltx.pattern.proxy.class1;

/**
 * Created by toonew on 2017/1/20.
 */
public class Car3 implements Moveable {
    private Car car;

    public Car3(Car car) {
        this.car = car;
    }

    @Override
    public void move() {
        long startTime = System.currentTimeMillis();

        System.out.println("汽车开始形式...");

        car.move();


        long endTime = System.currentTimeMillis();
        System.out.println("汽车move 结束，行驶时间：" + (endTime - startTime) + "毫秒！");
    }
}
