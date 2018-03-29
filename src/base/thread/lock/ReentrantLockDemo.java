package base.thread.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 出处:
 * https://segmentfault.com/q/1010000008531416
 * Created by toonew on 2017/3/1.
 */
public class ReentrantLockDemo {

    private Lock lock = new ReentrantLock();

    public void doingSomeThing() {
        //tryLock  会造成  重入锁，两重锁，但是我们释放了一次，所以 后面的线程无法再获得锁，这里应该用isLocked检测
        //System.out.println(Thread.currentThread().getName() + "是否获得了锁" + lock.tryLock());
        //System.out.println(Thread.currentThread().getName() + "是否获得了锁" + lock.isLocked());//因为多态是 以父类为准，这里无isLocked 需要用子类对象
        lock.lock();

        try {
            System.out.println(Thread.currentThread().getName());
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(Thread.currentThread().getName() + "释放了锁");
            lock.unlock();
        }
    }

    static class MyRunnable implements Runnable {
        private ReentrantLockDemo demo;

        private MyRunnable(ReentrantLockDemo demo) {
            this.demo = demo;
        }

        @Override
        public void run() {
            demo.doingSomeThing();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReentrantLockDemo demo = new ReentrantLockDemo();
        new Thread(new MyRunnable(demo)).start();
        Thread.sleep(1000);
        new Thread(new MyRunnable(demo)).start();
    }
}
