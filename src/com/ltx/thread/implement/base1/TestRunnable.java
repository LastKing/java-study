package com.ltx.thread.implement.base1;

/**
 * Created by toonew on 2017/2/13.
 */
public class TestRunnable implements Runnable {
    private String name;

    public TestRunnable(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            for (int k = 0; k < 100000000; k++) ;
            System.out.println(name + ": " + i);
        }
    }
}
