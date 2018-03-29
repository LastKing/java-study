package base.thread.demo.extend.base1;

/**
 * 基本的只需要 重写 run 就行了，其他的可以通过继承
 * Created by toonew on 2017/2/13.
 */
public class TestExtend extends Thread {
    public static void main(String[] args) {
        Thread t1 = new TestThread("阿三");
        Thread t2 = new TestThread("李四");
        t1.start();
        t2.start();
    }
}

class TestThread extends Thread {
    public TestThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            for (long k = 0; k < 100000000; k++) ;
            System.out.println(this.getName() + " :" + i);
        }
    }
}