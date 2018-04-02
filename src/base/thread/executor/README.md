# 线程与执行器

问题记录：
1. newWorkStealingPool有什么意义，ForkJoinPool好像在拆分什么东西？参考[参考](http://blog.dyngr.com/blog/2016/09/15/java-forkjoinpool-internals/)
2. FutureTask Future RecursiveTask ForkJoinTask Future 之间的关系
3. ScheduleThreadPool 实际应用也没有搞定，只是看了下基本的案例
4. 还有这3片文章的案例分析 https://zhuanlan.zhihu.com/p/33266682?utm_source=qq&utm_medium=social

java5开始引入executor框架，用来处理线程的启动，调度，销毁等线程的管理。

Executor框架包括：`线程池`，`Executors`，`Executor`，`ExecutorService`，
`CompletionService`，`Future`，`Callable`等。

## Executors 关系网络
ExecutorService继承了Executor接口（包含execute），增加了shutdown平滑关闭，拒绝新请求，等待旧请求完成。

ExecutorService生命周期：`运行`、`关闭`、`终止`

Exectors提供一系列工厂方法用于创建各种线程池：
1. newSingleThreadExecutor(int parallelism)   创建一个单线程化的Executor
2. newFixedThreadPool(int nThreads)           创建固定数目的线程池
3. newCachedThreadPool()                      创建一个可缓存的线程池
4. newScheduledThreadPool(int corePoolSize)   创建一个支持定时及周期性的任务执行的线程池
5. newWorkStealingPool                        创建一个拥有多个**并行**的线程池????（1.8新加）

以上1 2 3 5都返回一个Exexcutor，4返回了一个ScheduledExecutorService <br/>
123底层实现都是通过调用`ThreadPoolExecutor`来完成对象的生成，4是由`ScheduledThreadPoolExecutor`完成对象生成,5由`ForkJoinPool`完成

注意以上 123遵循后面的规范，ScheduleThreadPool和WorkStealingPool都不遵循,不知道它们怎么转到Thread.start中的，它们采用不同的底层实现。

ThreadPoolExecutor这个api可以用来自定义生成线程池，
`public ThreadPoolExecutor(int corePoolSize,int maximumPoolSize,long keepAliveTime,TimeUnit unit,BlockingQueue<Runnable> workQueue,....)`
* corePoolSize ：    保存的核心线程数，包括空闲线程
* maximumPoolSize ： 池中允许的最大线程数
* keepAliveTime ：   线程池中的空闲线程所能持续的最长存活时间
* unit ：            持续时间的单位
* workQueue ：       任务执行前保存任务的队列，仅保存由execute方法提交的Runnable任务。

pool中对通过execute/submit 新增的task处理方式：
1. 线程池中线程少于corePoolSize，即使线程池中有空闲线程，也会创建一条新的线程
2. 线程池中线程大于corePoolSize，但是缓存队列workQueue未满，则添加新的任务到workQueue中，按照FIFO等待执行
3. 线程池中线程大于corePoolSize，但是缓存队列workQueue已满，单线程数量少于MaximumPoolSize，则会创建新线程，处理被添加的任务
4. 线程池中线程等于maximumPoolsize，启动构造方法中的`RejectedExecutionHandler` handler，也就是拒绝策略，处理线程溢出，jdk提供4种
    * AbortPolicy策略： 直接抛出异常，阻止系统正常工作(不try/catch程序会直接退出）
    * CallerRunsPolicy策略：只要线程池未关闭，该策略直接在调用者线程中，不断运行当前的被丢弃的任务，直到成功`if(!e.isShutdown()){r.run();}`源码
    * DiscardOleddestPolicy策略： 丢弃一个队列中最新的任务，并尝试提交当前任务
    * DiscardPolicy策略：不处理，丢弃无法处理的任务

还有workQueue缓存队列的排队策略：
1. 直接提交  SynchronousQueue不缓存，并且maximumPoolSize为Integer.MAX_VALUE避免拒绝新提交的任务，newCachedThreadPool
2. 无界队列  LinkedBlockingQueue链表无限长度，maximumPoolSize值就无效了，newFixedThreadPool
3. 有界队列  ArrayBlockingQueue数组队列有长度，有助于防止资源耗尽，但是难调控和控制

上面知识结构主体[参考1**](https://blog.csdn.net/ns_code/article/details/17465497)
这一篇应该是模仿了[参考1](https://blog.csdn.net/kouwoo/article/details/48788867)
自定义线程池[参考2](https://blog.csdn.net/ns_code/article/details/17465497)，
拒绝策略[参考3](https://blog.csdn.net/chao_19/article/details/74055255),[参考4](https://blog.csdn.net/chaofanwei2/article/details/51393794)
线程池[single,fix,cache](https://www.cnblogs.com/study-everyday/archive/2017/04/20/6737428.html)

## Executor 执行器基本api

### scheduleAtFixedRate vs scheduleWithFixedDelay
scheduleAtFixedRate
```
00:00: Start making coffee
00:10: Finish making coffee
01:00: Start making coffee
01:10: Finish making coffee
02:00: Start making coffee
02:10: Finish making coffee
```

scheduleWithFixedDelay
```
00:00: Start making coffee
00:10: Finish making coffee
01:10: Start making coffee
01:20: Finish making coffee
02:20: Start making coffee
02:30: Finish making coffee
```
[此处对比出处StackOverFlow](https://stackoverflow.com/questions/24649842/scheduleatfixedrate-vs-schedulewithfixeddelay)


参考：
1. [线程和执行器](https://zhuanlan.zhihu.com/p/33266682?utm_source=qq&utm_medium=social)