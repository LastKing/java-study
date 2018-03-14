package com.base.thread.unknown.executor;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * create by toonew on 2018/2/10
 */
public class Test5 {

    public static void main(String[] args) throws Exception {

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

        Runnable task = () -> System.out.println("schedule " + System.nanoTime());
        ScheduledFuture<?> future = executor.schedule(task, 3, TimeUnit.SECONDS);

        TimeUnit.MILLISECONDS.sleep(1337);
        long remainingDelay = future.getDelay(TimeUnit.MILLISECONDS);
        System.out.printf("Remaining Delay: %sms ", remainingDelay);
    }

}
