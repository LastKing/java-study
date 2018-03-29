package base.thread.demo.extend.base2;

/**
 * 继承 线程，重写run 方法，start时创建线程，进入准备状态
 *
 * Created by toonew on 2017/1/18.
 */
public class ThreadDemo extends Thread {
    private Thread t;
    private String threadName;


    public ThreadDemo(String name) {
        this.threadName = name;
    }

    @Override
    public void run() {
        System.out.println("Running " + threadName);
        try {
            for (int i = 4; i > 0; i--) {
                System.out.println("Thread: " + threadName + ", " + i);
                // 让线程睡醒一会
                Thread.sleep(50);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread " + threadName + " interrupted.");
        }
        System.out.println("Thread " + threadName + " exiting.");
    }

    @Override
    public synchronized void start() {
        System.out.println("Staring" + threadName);
        if (t == null) {
            t = new Thread(this, threadName);
            t.start();
        }
    }
}
