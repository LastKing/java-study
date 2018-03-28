package com.base.thread.executor;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * exec
 * create by toonew on 2018/2/10
 */
public class Test1 {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
//        ExecutorService executor = Executors.newCachedThreadPool();       //可缓存线程池，
//        ExecutorService executor = Executors.newFixedThreadPool();        //定长线程池

//        executor.execute(() -> {});           //无返回值，无法确认知否成功完成
//        executor.submit(() -> {});            //返回一个future，用来判断任务是否成功

        executor.submit(() -> {
            String threadName = Thread.currentThread().getName();
            System.out.println("hello " + threadName);
        });

        //可以提交两种task
//        executor.submit(new Runnable() {});           // Runnable接口 (无返回值）
//        executor.submit(new Callable<Object>() {});   // Callable接口


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
