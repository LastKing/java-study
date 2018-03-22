# 线程系统学习之路

什么是线程?
线程是操作系统能运算调度的最小单位，它包含在进程中，是进程的运行单位，可以多线程对运行进行加速。


## Thread 创建方式
1. 实现 Runnable
2. 继承 Thread
3. 通过 Callable 和 Future    <br>
demo文件中3种线程创建的基本方式,[demo出处部分](http://www.runoob.com/java/java-multithreading.html)

### 几者之间的区别与联系?
继承方式一种最直接的实现，在实现因为Thread本身实现了Runnable，增加了更多的方法，用来处理线程工作的周边问题，
例如线程任务的添加以及，推出的清理工作，

实现方式，task任务之一，最终都是thread的start启动,最终还是需要将自己扔到thread中执行。

Callable和Future，特别容易和`Excutor`搅在一起讲，但是他两组合起来也只是一种task而已，只是更加复杂和简单，嘿嘿，
Callable相当于Runnable，也是一种task，类似，由Future将Callable转化成为普通的Runnable模式，简化线程间的通讯，
这个玩也估计就是和Executor配套产生的。[callable和future，作为普通task或者exector](http://blog.csdn.net/ghsau/article/details/7451464)区别参见。
https://www.cnblogs.com/dolphin0520/p/3949310.html


### 为什么线程只允许使用start()启动线程？
在分析分析代码，发现直接调用run，只是相当于调用了一个方法，而已并没有将run里面的任务，丢入线程组中，
在start方法内有一个`group.add(this);`，这个ThreadGroup是将任务真正多线程执行的地方（具体的分析后面补上）



