package com.base.thread.volatiles;

/**
 * 这个例子很像一个信号量的例子
 * 这里设置 volatile 才会将数据在两个线程间通向，
 * 根据网上的说法，
 * 是将这个变量 快速的从线程中的执行栈中强制刷新进入公共内存中
 * 从来数据的可见性
 * create by toonew on 2018/3/23
 */
public class Test1 {

    public static void main(String[] args) throws Exception {
        RunThread thread = new RunThread();
        thread.start();
        Thread.sleep(1000);
        thread.setRunFlag(false);
        System.out.println("flag is reseted: " + thread.isRunning());
    }

}

class RunThread extends Thread {
//    private volatile boolean isRunning = true;
    private boolean isRunning = true;

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunFlag(boolean flag) {
        isRunning = flag;
    }

    @Override
    public void run() {
        System.out.println("I'm come in...");
        boolean first = true;
        while (isRunning) {
            if (first) {
                System.out.println("I'm in while...");
                first = false;
            }
        }
        System.out.println("I'll go out.");
    }
}