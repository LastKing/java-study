package base.thread.synchronizeds.demo;

/**
 * 适用与原则2
 * create by toonew on 2018/3/22
 */
public class Test5 {
    class Inner {
        private void say1() {
            int i = 5;
            while (i-- > 0) {
                System.out.println(Thread.currentThread().getName() + " : Inner.say1()=" + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ie) {
                    ie.printStackTrace();
                }
            }
        }

        private void say2() {
//      private synchronized void  say2() {

            int i = 5;
            while (i-- > 0) {
                System.out.println(Thread.currentThread().getName() + " : Inner.say2()=" + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ie) {
                    ie.printStackTrace();
                }
            }
        }
    }

    private void say1(Inner inner) {
        synchronized (inner) {             //使用对象锁
            inner.say1();
        }
    }

    private void say2(Inner inner) {
        inner.say2();
    }

    public static void main(String[] args) {
        final Test5 t5 = new Test5();
        final Inner inner = t5.new Inner();
        Thread t1 = new Thread(() -> t5.say1(inner), "t1");
        Thread t2 = new Thread(() -> t5.say2(inner), "t2");

        t1.start();
        t2.start();
    }

}
