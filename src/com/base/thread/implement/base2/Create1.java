package com.base.thread.implement.base2;

/**
 * Created by toonew on 2017/1/18.
 */
public class Create1 {

    public static void main(String[] args) {
        RunnableDemo r1 = new RunnableDemo("Thread-1");
        r1.start();
        RunnableDemo r2 = new RunnableDemo("Thread-2");
        r2.start();
    }

}
