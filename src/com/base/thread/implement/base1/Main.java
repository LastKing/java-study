package com.base.thread.implement.base1;

/**
 * 0.0
 * Created by toonew on 2017/2/13.
 */
public class Main {
    public static void main(String[] args) {
        TestRunnable r1 = new TestRunnable("张三");
        TestRunnable r2 = new TestRunnable("李四");

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);

        t1.start();
        t2.start();

    }
}
