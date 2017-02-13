package com.ltx.pattern.proxy.class1;

/**
 * Created by toonew on 2017/1/20.
 */
public class Test {
    public static void main(String[] args) {
//        Car car = new Car();
//        car.move();

        //使用继承
//        Moveable m = new Car2();
//        m.move();

        //使用聚合
        Car car = new Car();
        Moveable c3 = new Car3(car);
        c3.move();

    }
}
