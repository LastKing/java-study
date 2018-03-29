# 知识目录结构

1. 什么是线程？什么是进程？
2. 创建线程的三种方式？
3. 线程生命周期
4. 线程synchronized volatile 原子性，可见性，顺序性
5. 线程通信 （共享内存、sleep、yield、notify、wait、信号量等）
6. 线程组（ThreadGroup）和线程池（Executors学习）

乱七八糟的原则:
1. happens-before 顺序性对可见性的影响，volatile好像能有一定程度的防止指令重排（一定的顺序，造成不同的可见性）

问题列表：
1. 生产者和消费者问题
2. 单例双重判断