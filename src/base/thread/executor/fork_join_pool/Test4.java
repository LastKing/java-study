package base.thread.executor.fork_join_pool;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

/**
 * 这个案例有问题：这个还是按照普通线程池的使用方法
 * 其实 ForkJoinPool 线程池增加了一种RecursiveTask/RecursiveAction（有/无返回值）新的任务队列
 * 用于将任务细化处理，普通线程池实现call方法，它实现compute
 * https://zhuanlan.zhihu.com/p/33266682?utm_source=qq&utm_medium=social
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

    private static Callable<String> callable(String result, long sleepSeconds) {
        return () -> {
            TimeUnit.SECONDS.sleep(sleepSeconds);
            System.out.println("thread " + Thread.currentThread().getName());
            return result;
        };
    }
}
