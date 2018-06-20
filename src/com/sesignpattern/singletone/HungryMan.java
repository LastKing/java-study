package com.sesignpattern.singletone;

/**
 * 饿汉模式 线程安全
 * Created by toonew on 2017/3/1.
 */
public class HungryMan {
    private static HungryMan ourInstance = new HungryMan();

    public static HungryMan getInstance() {
        return ourInstance;
    }

    private HungryMan() {
    }
}
