package base.thread.executor;

import java.util.concurrent.*;

/**
 * 只是铺垫 看test2，和thread/demo中的call 例子，了解基本callable和future的关系，以及与Runnable的关系与区别
 * 线程池的基本套路
 * 1.生成 你需求的 线程池
 * 2.生成需要执行的task ，可是Runnable或者Callable
 * 3.将task 提交到 线程池中，返回future或者futureList
 * 4.所有的结果都是从future中提取
 * create by toonew on 2018/2/10
 */
public class Test1 {

    public static void main(String[] args) {
        //官方给定几种基本线程池
        ExecutorService executor = Executors.newSingleThreadExecutor();
//        ExecutorService executor = Executors.newCachedThreadPool();      //可缓存线程池，
//        ExecutorService executor = Executors.newFixedThreadPool(5);      //定长线程池
//        ExecutorService executor = Executors.newScheduledThreadPool(5);  //创建一个定期执行task的线程池（返回一个ScheduledExecutorService）
//        ExecutorService executor = Executors.newWorkStealingPool();      //创建一个xxxx的线程池(1.8新增，通过ForkJoinPool判断)

        //自定义线程池 （主要是第一个）
//        Executor executor=new ThreadPoolExecutor();
//        Executor executor=new ScheduledThreadPoolExecutor();
//        Executor executor=new ForkJoinPool();


        //可以提交两种task
//        executor.submit(new Runnable() {});           // Runnable接口 (无返回值）
//        executor.submit(new Callable<Object>() {});   // Callable接口

        //任务的提交模式
//        executor.execute(() -> {});           //无返回值，无法确认知否成功完成
//        executor.submit(() -> {});            //返回一个future，用来判断任务是否成功
//        executor.invokeAll();                 //submit的批量版本

        //submit 几种，注意这里的Callable不是runnable，第二个方法的意思是runnable运行成功的化，添加一个固定的返回值
//        executor.submit(Callable < T > task);
//        executor.submit(Runnable task, T result);
//        executor.submit(Runnable task);

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
