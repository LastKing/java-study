package base.thread.executor;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * create by toonew on 2018/2/10
 */
public class Test4 {

    public static void main(String[] args) throws Exception {

        ExecutorService executor = Executors.newWorkStealingPool();
        List<Callable<String>> callables = Arrays.asList(
                callable("task1", 2),
                callable("task2", 1),
                callable("task3", 3));
        String result = executor.invokeAny(callables);
        System.out.println(result);
    }

    static Callable<String> callable(String result, long sleepSeconds) {
        return () -> {
            TimeUnit.SECONDS.sleep(sleepSeconds);
            System.out.println("thread " + Thread.currentThread().getName());
            return result;
        };
    }
}
