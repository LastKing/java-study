# ThreadPoolExecutor源码分析

基本构造函数分析和api看README就行了

## 状态机制
1. RUNNING：可以接受新的任务，也可以处理阻塞队列里的任务
2. SHUTDOWN：不接受新的任务，但是可以处理阻塞队列里的任务
3. STOP：不接受新的任务，不处理阻塞队列里的任务，中断正在处理的任务
4. TIDYING：过渡状态，也就是说所有的任务都执行完了，当前线程池已经没有有效的线程，这个时候线程池的状态将会TIDYING，并且将要调用terminated方法
5. TERMINATED：终止状态。terminated方法调用完成以后的状态

## 线程池执行任务流程
1. worker类
2. ThreadFactory接口newThread()
3. 还有各种乱七八糟的。。。没看完
https://fangjian0423.github.io/2016/03/22/java-threadpool-analysis/