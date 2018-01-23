package com.cas;

/**
 * synchronized 解决方案，按时会导致性能问题
 * 会增加性能损耗。
 */
public class Test2 {

    public static int count = 0;

    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                for (int j = 0; j < 100; j++) {
                    synchronized (Test2.class) {
                        count++;
                    }
                }
            }).start();
        }

        try {
            Thread.sleep(2100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("count=" + count);
    }
}
