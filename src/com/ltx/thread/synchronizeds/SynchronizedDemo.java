package com.ltx.thread.synchronizeds;

/**
 * http://www.imooc.com/video/6818
 * 多线程之可见性
 *
 * 因为线程的执行本身就是不确定的，加了synchronized关键字只能确保互斥访问这段代码以及变量的可见性，
 * 并不能保证程序的执行顺序，也就是read和write方法的执行顺序。
 *
 * Created by Rain on 2017/2/14.
 */
public class SynchronizedDemo {
    //共享变量
    private boolean ready = false;
    private int result = 0;
    private int number = 1;

    //写的操作
    public synchronized void write() {
        ready = true;   //1.1
        number = 2;     //1.2
    }

    //读的操作
    public synchronized void read() {
        if (ready) {                //2.1
            result = number * 3;    //2.2
        }
        System.out.println("result 的值为: " + result);
    }

    private class ReadWriteThread extends Thread {
        private boolean flag;

        public ReadWriteThread(boolean flag) {
            this.flag = flag;
        }

        @Override
        public void run() {
            if (flag) {
                write();
            } else {
                read();
            }
        }
    }

    public static void main(String[] args) {
        SynchronizedDemo syncDemo = new SynchronizedDemo();
        syncDemo.new ReadWriteThread(true).start();
        syncDemo.new ReadWriteThread(false).start();

        //result 可能是 0或者6
        //第一： 1.1 --> 2.1 --> 2.2 --> 1.2
        //第二： 1.2 --> 2.1 --> 2.2 --> 1.1
    }
}
