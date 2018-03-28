package com.base.thread.communication;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * callable 和 futureTask的组和使用，实现了子进程可以返回参数
 * create by toonew on 2018/3/24
 */
public class Test5 {

    public static void main(String[] args) {
        doTaskWithResultInWorker();
    }

    private static void doTaskWithResultInWorker() {
        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("Task starts");
                Thread.sleep(1000);
                int result = 0;
                for (int i = 0; i <= 100; i++) {
                    result += i;
                }
                System.out.println("Task finished and return result");
                return result;
            }
        };

        FutureTask<Integer> futureTask = new FutureTask<>(callable);
        new Thread(futureTask).start();
        try {
            System.out.println("Before futureTask.get()");
            System.out.println("Result:" + futureTask.get());
            System.out.println("After futureTask.get()");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
