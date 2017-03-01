package com.base.thread.extend.base2;

/**
 * Created by Rain on 2017/2/14.
 */
public class TestExtends {
    public static void main(String[] args) {
        ThreadDemo t1 = new ThreadDemo("Thread-a");
        t1.start();
        ThreadDemo t2 = new ThreadDemo("Thread-b");
        t2.start();
    }
}
