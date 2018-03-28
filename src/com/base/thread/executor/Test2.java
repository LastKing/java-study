package com.base.thread.executor;

import java.util.concurrent.*;

/**
 * create by toonew on 2018/2/10
 */
public class Test2 {

    public static void main(String[] args) throws Exception {

        Callable<Integer> task = () -> {
            TimeUnit.SECONDS.sleep(10);
            return 123;
        };

        ExecutorService executor = Executors.newFixedThreadPool(1);
        Future<Integer> future = executor.submit(task);

        System.out.println("future done? " + future.isDone());
//        Integer result = future.get();
        Integer result = future.get(5, TimeUnit.SECONDS);
        System.out.println("future done? " + future.isDone());
        System.out.print("result: " + result);

    }

}
