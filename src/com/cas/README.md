# CAS (Compare and Swap)

多线程导致数据不一致问题一种解决方案

## 问题场景
count++，在多线程下变量共享出现的问题

## 解决方案
1. synchronized 方案 （悲观锁）
优点：安全性能极高（瞎编的，嘿嘿）
缺点：性能差，会让没有得到锁资源的线程进入**Blocked**状态，而后在争夺到锁资源时恢复成**Runnable**状态，
在这个过程中涉及到操作系统**用户模式**和**内核模式**，代价极大。
尽管1.6优化过了，从偏向锁到轻量锁再到重量锁的过度，但是最后的重量级锁，性能仍然底下。

2. cas方案 （乐观锁）
cas的简化 实质为： 3个基本操作数：内存地址V,旧的预期值A，要修改的新值B
* compare过程：反复对比,直到V地址的数值等于旧的预期值，这个尝试的过程称为**自旋**
* swap过程   : 交换值
缺点：
* CPU开销较大：比较的过程，会大量进行
* 不能保证代码块的原子性，只是变量的原子性操作

参考：
1. [漫画：什么是 CAS 机制？](https://mp.weixin.qq.com/s?__biz=MzIxNjA5MTM2MA==&mid=2652434378&idx=1&sn=f098c3b949acccdf6768302219f92b94&chksm=8c621045bb159953c69cda6af16f1e3fb5ec44421a50260cb079a93e783cf4d4fb3449fa69ba&scene=21#wechat_redirect)
2. [漫画：什么是CAS机制？（进阶篇）](https://mp.weixin.qq.com/s?__biz=MzIxNjA5MTM2MA==&mid=2652434390&idx=1&sn=897ab32eee826a014a95ead809d9c7e7&chksm=8c621059bb15994f469030d1b788c5e5d1e40ba94116e35f224b8864d30d1d771affa6655ec3&mpshare=1&scene=23&srcid=0116W6BjfVBeJqR0D2WtVf1z#rd)

第一篇
基本的cas自旋比较和交换 <br>
第二篇
* 解释了AtomicInteger中的实际应用，虽然1.8中的实现有差异，但是答题思路应该不会错把。。。大概
* 介绍了java中一个**unsafe**对象，jvm的提供的后门，让java拥有硬件级别的原子操作,对比中有大作用。
* ABA问题
    * 简化描述两个线程执行了同样的a-》b操作，只应该有一个成功，另一个失败，但是一个线程阻塞了，又有线程3做了b-》a的操作，结果又变成了a，
    线程2又成功了，本来应该执行一个a-》b结果在这里2次。
    * 解决方案增加 版本  实例（AtomicStampedReference）
