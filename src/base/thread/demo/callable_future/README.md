# Callable / Future实现原理

Callable有点类似Runnable，也是一种task，

* 前者call()，有返回值
* 后者run()，无返回值 

Future接口规定了一堆对线程状态的管理方法，单纯这两者无法直接在thread直接使用，因为没有实现run方法，无法被线程调用 

由FutureTask继承Runnable并将Callable转化成为普通的Runnable模式，实现线程的状态管理，并返回值的。
可以单独在`Thread`中使用

在`Exector`中使用时将Callable直接submit给executor，通过submit将Callable扔到Runnable中，
并返回future,返回Future管理状态和获取值，（暂时只确定ThreadPoolExecutor线程池,参见`AbstractExecutorService.submitsubmit(Callable<T> task)`）

## FutureTask实现原理分析

FutureTask 实现了Runnable&Future，通过run调用call，增加状态机制，增加返回值

1. NEW          0 构造FutureTask，并对callable内部成员赋值
2. COMPLETING   1 task正在被处理
3. NORMAL       2 正常处理的最终状态
4. EXCEPTIONAL  3 task执行过程出现异常，此时结果设值为exception
5. CANCELLED    4 表明task被cancel（task还没有执行就被cancel的状态）.
6. INTERRUPTING 5 task运行过程中被interrupt时，设置的中间状态
7. INTERRUPTED  6 中断完毕的最终状态，几种情况

有些值的具体设置，FutureTask中我还没找到，不知道是不是还有更加底层的代码，但是没有发现原生代码的标志

状态机的转化可能性：

* NEW -> COMPLETING -> NORMAL
* NEW -> COMPLETING -> EXCEPTIONAL
* NEW -> CANCELLED
* NEW -> INTERRUPTING -> INTERRUPTED

周边知识欠缺列表（呆补充）：

1. [LockSupport](https://www.tuicool.com/articles/MveUNzF)该方法牵扯了get的实现，因为get是阻塞式awaitDone

参考：

1. 本文主要出处[Java并发编程：Callable、Future和FutureTask原理解析](https://blog.csdn.net/codershamo/article/details/51901057)源码解析需要先了解基本的套路
2. [callable和future，在普通thread或者executor运行](https://www.cnblogs.com/dolphin0520/p/3949310.html)区别参见。