package com.ltx.pattern.single;

/**
 * Created by toonew on 2017/1/20.
 */
public class Hungry {
    //1.私有化 构造放话

    private Hungry() {
    }

    //2.创建类的实例 （ 饿汉，类加载，这个实例就生成了）
    private static Hungry hungry = new Hungry();

    //3.提供一个 获取实例的方法
    public static Hungry getInstance() {
        return hungry;
    }

}
