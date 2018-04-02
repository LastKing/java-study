package base.thread.demo.callable_future;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * FutureTask 实现了Runnable&Future，通过run调用call，增加状态机制
 *
 * 这是CallTask和future的最基本的例子
 * 将callTask丢入future，用于管理状态和获取结果
 * future丢入thread中实际运行
 * future.get同步获取结果，结果会阻塞式获取
 * 关于executor和future的连用，请去executor去看
 */
public class Test {

    public static void main(String[] args) throws Exception {

        CallTask callable = new CallTask();
        CallTask2 callable2 = new CallTask2();

        FutureTask<Integer> ft = new FutureTask<>(callable);
        FutureTask<Integer> ft2 = new FutureTask<>(callable2);

        new Thread(ft, "thread-a ").start();
        new Thread(ft2, "thread-b ").start();

        Integer result = ft.get();                              //同步阻塞
        System.out.println("a 子线程的返回值：" + result);

        Integer result2 = ft2.get(5, TimeUnit.SECONDS); //同步阻塞 ，别理解错了，这里是timeout超时，意思是最长等待时间，不是等5秒再get。。
        System.out.println("b 子线程的返回值：" + result2);
    }
}

class CallTask implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        int i = 0;
        for (; i < 100; i++)
            System.out.println(Thread.currentThread().getName() + " " + i);
        return i;
    }
}

class CallTask2 implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        int i = 0;
        TimeUnit.SECONDS.sleep(2);
        for (; i < 100; i++)
            System.out.println(Thread.currentThread().getName() + " " + i);
        return i;
    }
}
