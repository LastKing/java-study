package base.thread.executor;

import java.util.concurrent.*;

/**
 * 只是铺垫 看test2，和 /thread/demo中的call 例子，了解基本callable和future的关系，以及与Runnable的关系与区别
 * 线程池的基本套路
 * 1.生成 你需求的 线程池
 * 2.生成需要执行的task ，可是Runnable或者Callable
 * 3.将task 提交到 线程池中，返回future或者futureList
 * 4.所有的结果都是从future中提取
 * create by toonew on 2018/2/10
 */
public class Test1 {

    public static void main(String[] args) throws Exception {
        //官方给定几种基本线程池
        ExecutorService executor = Executors.newSingleThreadExecutor();
//        ExecutorService executor = Executors.newCachedThreadPool();      //可缓存线程池
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
//        executor.invokeAny();                 //submit的批量版本

        //submit 几种，注意这里的Callable不是runnable，第二个方法的意思是runnable运行成功的化，添加一个固定的返回值
//        executor.submit(Callable <T> task);           //有返回值
//        executor.submit(Runnable task, T result);     //task无返回值，result为成功时的固定返回值
//        executor.submit(Runnable task);               //无返回值

        Future<String> future = executor.submit(() -> {
            String threadName = Thread.currentThread().getName();
            System.out.println("hello " + threadName);
        }, "String");

        System.out.println("test " + future.get() + " test");

        try {
            System.out.println("attempt to shutdown executor");
            //关闭策略
            executor.shutdown();            //关闭，拒绝新请求的加入，给已经在运行的任务发等待结束信号，并等待老任务结束
//            executor.shutdownNow();       //立刻关闭，拒绝新请求的加入，立即终止老任务
            executor.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (!executor.isTerminated())
                System.out.println("cancel non-finished  tasks");

            executor.shutdown();
            System.out.println("shutdown finished");
        }
    }
}
