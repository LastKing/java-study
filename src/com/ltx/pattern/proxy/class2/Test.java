package com.ltx.pattern.proxy.class2;

/**
 * Created by toonew on 2017/1/20.
 */
public class Test {
    public static void main(String[] args) {
        Car car = new Car();
        CarTimeProxy ctp = new CarTimeProxy(car);
        CarLogProxy clp = new CarLogProxy(ctp);
        clp.move();
    }
}
