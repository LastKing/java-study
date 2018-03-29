package base.thread.synchronizeds.demo;

/**
 * 同步块或者同步方法中任意一个被执行，另一个线程都不能访问任何同步代码
 * create by toonew on 2018/3/22
 */
public class Test4 {
    private void say1() {
        synchronized (this) {
            int i = 5;
            while (i-- > 0) {
                System.out.println(Thread.currentThread().getName() + " : " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private synchronized void say2() {
        int i = 5;
        while (i-- > 0) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        final Test4 test2 = new Test4();
        Thread t1 = new Thread(() -> test2.say1(), "t1");
        Thread t2 = new Thread(() -> test2.say2(), "t2");
        t1.start();
        t2.start();
    }

}
