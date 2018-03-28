package com.base.thread.communication;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch 倒数统计器，
 * 设置初始值，每次减一，到0开始
 * create by toonew on 2018/3/24
 */
public class Test3 {

    public static void main(String[] args) {
        runDAfterABC();
    }

    private static void runDAfterABC() {
        int worker = 3;
        CountDownLatch countDownLatch = new CountDownLatch(worker);

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("D is waiting for other three threads");
                try {
                    countDownLatch.await();
                    System.out.println("All done, D starts working");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        for (char threadName = 'A'; threadName <= 'C'; threadName++) {
            final String tN = String.valueOf(threadName);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(tN + " is working");
                    try {
                        Thread.sleep(100);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    System.out.println(tN + " finished");
                    countDownLatch.countDown();
                }
            }).start();
        }

    }

}
