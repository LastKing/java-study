package com.ltx.pattern.single;

/**
 * 区别：
 *  饿汉模式的特点是加载类比较慢，但运行时获取对象快，线程安全
 *  懒汉模式的特点是加载类比较快，但是运行获取对象慢，线程不安全
 * Created by toonew on 2017/1/20.
 */
public class Test {

    public static void main(String[] args) {
        Hungry h1 = Hungry.getInstance();
        Hungry h2 = Hungry.getInstance();
        System.out.println(h1 == h2);

        Lazy l1 = Lazy.getInstance();
        Lazy l2 = Lazy.getInstance();
        System.out.println(l1 == l2);
    }

}


