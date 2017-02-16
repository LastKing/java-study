package com.ltx.thread.synchronizeds;

/**
 * Created by Rain on 2017/2/16.
 */
public class WaitNotify implements Runnable {
    private int number;
    private byte res[];
    private static int count = 5;

    public WaitNotify(int number, byte[] res) {
        this.number = number;
        this.res = res;
    }

    @Override
    public void run() {
        synchronized (res) {
            while (count-- > 0) {
                try {
                    res.notify();
                    System.out.println(" " + number);
                    res.wait();
                    System.out.println("------线程" + Thread.currentThread().getName() + "获得锁，wait()后的代码继续运行：" + number);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    public static void main(String[] args) {
        final byte a[] = {0};
        new Thread(new WaitNotify(1, a), "1").start();
        new Thread(new WaitNotify(2, a), "2").start();
    }
}
