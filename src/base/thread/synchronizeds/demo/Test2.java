package base.thread.synchronizeds.demo;

/**
 * 当线程访问一个同步代码块时，其他线程仍然可以访问其他非同步代码块
 * create by toonew on 2018/3/22
 */
public class Test2 {
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

    private void say2() {
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
        final Test2 test2 = new Test2();
        Thread t1 = new Thread(() -> test2.say1(), "t1");
        Thread t2 = new Thread(() -> test2.say2(), "t2");
        t1.start();
        t2.start();
    }

}
