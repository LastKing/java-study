package com.sesign_pattern.singletone;

/**
 * 懒汉，非线程安全
 * Created by toonew on 2017/3/1.
 */
public class LazyMan {

    private static LazyMan lazyMan;

    private LazyMan() {
    }

    //因为和可能出现多个线程同时 申请实例，造成lazyMan 出现多个
    public static LazyMan getInstance() {
        if (lazyMan == null) {
            lazyMan = new LazyMan();
        }
        return lazyMan;
    }
}
