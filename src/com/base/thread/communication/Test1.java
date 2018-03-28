package com.base.thread.communication;

/**
 * join 等待 A.join 中A线程完成
 * create by toonew on 2018/3/23
 */
public class Test1 {

    public static void main(String[] args) {
        demo1();
    }

    private static void demo1() {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                printNumber("thread1");
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread2 开始等待 thread1");
                try {
                    thread1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                printNumber("thread2");
            }
        });

        thread1.start();
        thread2.start();
    }

    private static void printNumber(String threadName) {
        int i = 0;
        while (i++ < 3) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(threadName + " print:" + i);
        }
    }
}
