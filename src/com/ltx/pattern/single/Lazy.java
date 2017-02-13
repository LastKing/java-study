package com.ltx.pattern.single;

/**
 * Created by toonew on 2017/1/20.
 */
public class Lazy {
    private Lazy() {
    }

    //只是声明，在函数并未 调用时，并不会创建实例
    private static Lazy lazy;

    public static Lazy getInstance() {
        if (lazy == null) {
            lazy = new Lazy();
        }
        return lazy;
    }

}
