package com.base.thread.implement.base2;

/**
 * 实现run 并且自建一个 线程执行
 * Created by toonew on 2017/1/18.
 */
public class RunnableDemo implements Runnable {

    private Thread t;
    private String threadName;

    public RunnableDemo(String threadName) {
        this.threadName = threadName;
        System.out.println("Creating " + threadName);
    }

    @Override
    public void run() {
        System.out.println("Running" + threadName);
        try {
            for (int i = 4; i > 0; i--) {
                System.out.println("Thread: " + threadName + ", " + i);
                // 让线程睡眠一会
                Thread.sleep(50);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread " + threadName + " interrupted.");
        }
        System.out.println("Thread " + threadName + " exiting.");
    }

    public void start() {
        System.out.println("Staring" + threadName);
        if (t == null) {
            t = new Thread(this, threadName);
            t.start();
        }
    }


}
