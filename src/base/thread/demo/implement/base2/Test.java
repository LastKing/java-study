package base.thread.demo.implement.base2;

/**
 * Created by toonew on 2017/1/18.
 */
public class Test {

    public static void main(String[] args) {
        RunnableTask r1 = new RunnableTask("Thread-1");
        r1.start();
        RunnableTask r2 = new RunnableTask("Thread-2");
        r2.start();
    }

}
