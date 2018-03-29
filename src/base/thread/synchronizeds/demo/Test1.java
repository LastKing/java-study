package base.thread.synchronizeds.demo;

/**
 * 1.表明被synchronized修饰的代码块，在执行时，获得锁，另一个线程无法获得
 * http://www.cnblogs.com/GnagWang/archive/2011/02/27/1966606.html#!comments
 * Created by Rain on 2018/3/22.
 */
public class Test1 {
    public static void main(String[] args) {
        RunnableTask t1 = new RunnableTask();
        Thread ta = new Thread(t1, "A");
        Thread tb = new Thread(t1, "B");
        ta.start();
        tb.start();
    }
}

class RunnableTask implements Runnable {
    @Override
    public void run() {
        synchronized (this) {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + " synchronized loop " + i);
            }
        }
    }
}