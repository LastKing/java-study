package com.base.thread.unknown.sync;

/**
 * create by toonew on 2018/2/10
 */
public class Test1 {

    private static int count = 0;

    private synchronized static void increment() {
        count += 1;
    }

    public static void main(String[] args) throws Exception {

        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                for (int j = 0; j < 10000; j++)
                    increment();
            }).start();
        }
        Thread.sleep(1000);

        System.out.println(count);
    }

}
