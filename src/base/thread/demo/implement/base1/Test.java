package base.thread.demo.implement.base1;

/**
 * 0.0
 * Created by toonew on 2017/2/13.
 */
public class Test {
    public static void main(String[] args) {
        RunnableTask r1 = new RunnableTask("张三");
        RunnableTask r2 = new RunnableTask("李四");

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);

        t1.start();
        t2.start();
    }
}
