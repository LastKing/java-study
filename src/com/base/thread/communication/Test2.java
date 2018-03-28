package com.base.thread.communication;

/**
 * wait 和 notify 的组合使用，
 * 这个只能在同步块或者同步方法中使用
 * create by toonew on 2018/3/24
 */
public class Test2 {

    public static void main(String[] args) {
        demo();
    }

    private static void demo() {
        byte[] lock = new byte[1];

        Thread thread_a = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    System.out.println("thread_a 1");
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("thread_a 2");
                    System.out.println("thread_a 3");
                }
            }
        });

        Thread thread_b = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    System.out.println("thread_b 1");
                    System.out.println("thread_b 2");
                    System.out.println("thread_b 3");
                    lock.notify();
                }
            }
        });
        thread_a.start();
        thread_b.start();
    }

}