package com.base.thread.unknown.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * create by toonew on 2018/2/10
 */
public class Test1 {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(() -> {
            String threadName = Thread.currentThread().getName();
            System.out.println("hello " + threadName);
        });

        try {
            System.out.println("attempt to shutdown executor");
            executor.shutdown();
            executor.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (!executor.isTerminated()) {
                System.out.println("cancel non-finished  tasks ");
            }
            executor.shutdown();
            System.out.println("shutdown finished");
        }
    }
}
