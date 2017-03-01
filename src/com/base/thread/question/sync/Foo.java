package com.base.thread.question.sync;

/**
 * 0.0
 * Created by toonew on 2017/2/14.
 */
public class Foo {
    private int x = 100;

    public int getX() {
        return x;
    }

    public int fix(int y) {
        synchronized (this) {
            x = x - y;
        }
        return x;
    }
}
