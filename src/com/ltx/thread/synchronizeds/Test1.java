package com.ltx.thread.synchronizeds;

/**
 * Created by Rain on 2017/2/14.
 */
public class Test1 implements Runnable {
    private static int count;

    public Test1() {
        count = 0;
    }


    @Override
    public void run() {
        synchronized (this) {
            for (int i = 0; i < 5; i++) {
                try {
                    System.out.println(Thread.currentThread().getName() + ":" + (count++));
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public int getCount() {
        return count;
    }

    public static void main(String[] args) {
        //这时创建了两个SyncThread的对象syncThread1和syncThread2，
        // 线程thread1执行的是syncThread1对象中的synchronized代码(run)，
        // 而线程thread2执行的是syncThread2对象中的synchronized代码(run)；
        // 我们知道synchronized锁定的是对象，这时会有两把锁分别锁定syncThread1对象和syncThread2对象，
        // 而这两把锁是互不干扰的，不形成互斥，所以两个线程可以同时执行。
//        Test1 t = new Test1();
//        Thread thread1 = new Thread(t, "SyncThread1");
//        Thread thread2 = new Thread(t, "SyncThread2");
//        thread1.start();
//        thread2.start();


        //不是说一个线程执行synchronized代码块时其它的线程受阻塞吗？
        // 为什么上面的例子中thread1和thread2同时在执行。这是因为synchronized只锁定对象，
        // 每个对象只有一个锁（lock）与之相关联，而上面的代码等同于下面这段代码：
        Thread thread1 = new Thread(new Test1(), "SyncThread1");
        Thread thread2 = new Thread(new Test1(), "SyncThread2");
        thread1.start();
        thread2.start();

    }
}
