package base.thread.executor.schedule;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 *
 * https://zhuanlan.zhihu.com/p/33266682?utm_source=qq&utm_medium=social
 * create by toonew on 2018/2/10
 */
public class Test6 {

    public static void main(String[] args) {

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        Runnable task = () -> System.out.println("Scheduling: " + System.nanoTime());
        int initialDelay = 0;

        int period = 1;
        executor.scheduleAtFixedRate(task, initialDelay, period, TimeUnit.SECONDS);

        int delay = 1;
        executor.scheduleWithFixedDelay(task, initialDelay, delay, TimeUnit.SECONDS);
    }

}
