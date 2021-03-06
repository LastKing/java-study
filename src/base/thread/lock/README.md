# 锁的分类学习

锁的几种分类方式

1. 悲观锁 和 乐观锁
2. 锁的膨胀： 无锁状态 --》偏向锁 --》轻量级锁 --》重量级锁
3. 轻量级锁 - 自旋锁 - cas 关系
4. 阻塞锁 synchronized、ReentrantLock
5. 可重入锁 synchronized ReentrantLock
6. 轮训锁 和 定时锁
7. 显示锁 和 内置锁
8. 读锁 和 写锁
9. 对象锁 和 类锁
10. 锁粗化
11. 互斥所 共享锁
12. 共享锁 和 排它锁
13. 锁消除

## 1.悲观锁和乐观锁
悲观锁：synchronized和AQS框架先cas，达到一定条件才会转化成悲观锁，RetreenLock

乐观锁：java基本都是cas操作实现 （主要用于读多写少，写入时间段短）
* 自旋锁 ：     避免用户线程和内核的切换的消耗 （一种轻量级锁）
* 偏向锁 ：     java6引入，偏向第一个访问锁的线程，``它通过消除资源无竞争情况下的同步原语，进一步提高了程序的运行性能。``
* 轻量级锁 ：   在偏向锁下发生，第二线程加入竞争时升级为轻量级锁

需要重新学习一个`markwords`

## 2.synchronized的执行顺序（锁膨胀）
1中基本稍稍介绍了几种基本基本的锁，synchronized，不是默认直接上来就是最悲观的锁，锁的级别是一点点加上去的：<br/>
`无锁状态 --》偏向锁 --》轻量级锁 --》重量级锁`


## 3.自旋锁 与 cas
*我的理解是就是不断去对比，判断，如果不能修改就不断从新算，保持在运行状态，不会将自己阻塞转化状态，
知道条件满足，实现转换。*（这一段理解貌似还有问题）
我的理解感觉自旋锁只是一种规范，并不是实现，cas就像它的一个实现,有什么临界点的概念
参考：
* [CAS和自旋锁(spin lock)](http://www.cnblogs.com/thomaschen750215/p/4122068.html)
* [乐观的并发策略——基于CAS的自旋](https://blog.csdn.net/wangyangzhizhou/article/details/39160471)


## 4.阻塞锁
**阻塞锁**指的是线程进入阻塞状态，阻塞锁与自旋锁的不同，阻塞锁修改了线程的当前运行状态
* 阻塞锁的优势在于，阻塞的线程不会占用cpu时间，不会导致cpu占用率过高，但进入时间以及恢复时间都要比自旋锁略慢
* 在竞争激烈的情况下 阻塞锁的性能要明显高于自旋锁
* 理想的情况则是; 在线程竞争不激烈的情况下，使用自旋锁，竞争激烈的情况下使用，阻塞锁
出处：[Java锁的种类以及辨析（三）：阻塞锁](http://ifeve.com/java_lock_see3/)

## 5.可重入锁
可重入锁，也称作递归锁，指的同一线程外层函数获得锁后，内层递归仍然可以获得锁，并不受影响。
出处：[Java锁的种类以及辨析（四）：可重入锁](http://ifeve.com/java_lock_see4/)

参考
1. [各种锁的分类](https://blog.csdn.net/a314773862/article/details/54095819)
