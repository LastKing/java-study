# 线程系统学习之路

## 线程与进程的区别
* 线程间资源是共享的，讲安全：信号量，锁，原子操作
* 进程间资源是独立的，讲通讯：管道，共享内存
* 你还是先去搞清楚什么是线程，什么是进程<br/>
[参考出处](https://www.zhihu.com/question/31843830)

什么是线程?
线程是操作系统能运算调度的最小单位，它包含在进程中，是进程的运行单位，可以多线程对运行进行加速。

## Thread 创建方式
1. 实现 Runnable
2. 继承 Thread
3. 通过 Callable 和 Future    <br>
demo文件中3种线程创建的基本方式,[demo出处部分](http://www.runoob.com/java/java-multithreading.html)

### 几者之间的区别与联系?
继承方式一种最直接的实现，在实现因为Thread本身实现了Runnable，增加了更多的方法，用来处理线程工作的周边问题，
例如线程任务的添加，退出清理工作等。

实现方式，task任务之一，最终都是thread的start启动,最终还是需要将自己扔到thread中执行，无返回值，但是callable有。

Callable和Future，特别容易和`Excutor`搅在一起讲，但是他两组合起来也只是一种task而已，只是更加复杂和简单，嘿嘿，
Callable相当于Runnable，也是一种task，类似但是没有继承Runnable，由Future继承Runnable并将将Callable转化成为普通的Runnable模式，简化线程间的通讯，
这个玩也估计就是和Executor配套产生的。[callable和future，作为普通task或者exector](http://blog.csdn.net/ghsau/article/details/7451464)区别参见。
https://www.cnblogs.com/dolphin0520/p/3949310.html

### 为什么线程只允许使用start()启动线程？
在分析分析代码，发现直接调用run，只是相当于调用了一个方法，而已并没有将run里面的任务，丢入线程组中，
在start方法内有一个`group.add(this);`，这个ThreadGroup是将任务扔到多线程组中，start中调用start0()方法，
而`private native void start0();`则是一个调用原生方法的函数，直接调用底层的c方法，根据不同的系统将java多线程影射到系统原生线程上。



### 线程组/线程池(ThreadGroup/ThreadPool)区别
ThreadGroup只是单纯的管理多线程，没有重复性工作 ，每个线程在创建时都会被丢尽一个threadGroup中，归属于父进程组
ThreadPool在管理多线程的基础上，增加复用，减少创建和销毁的消耗

## 各种同步与锁的学习

### synchronized 与 volatile 对比

synchronized同步的，为多线程下的操作提供了**原子性**和**可见性**，保证操作在多线程下依然会和单线程执行的结果一样。

volatile保证了多线程下的**可见线**，保证了线程在操作时，将数据从工作内存中刷新到主存中并且读取主内存中的变量。


## thread state 学习
通过状态的转换，实现java多线程，按照设想顺序执行。


