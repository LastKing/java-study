# 锁的分类学习

锁的几种分类方式

1. 共享锁 和 排它锁
2. 自旋锁 cas
3. 阻塞锁 synchronized、ReentrantLock
4. 可重入锁 synchronized ReentrantLock
5. 悲观锁 和 乐观锁 （行锁、表锁、读锁、写锁 独占锁。。 ： cas ）
6. 轮训锁 和 定时锁
7. 显示锁 和 内置锁
8. 读锁 和 写锁
9. 对象锁 和 类锁
10. 锁粗化
11. 互斥所 共享锁
12. 锁的状态： 无锁状态 --》偏向锁 --》轻量级锁 --》重量级锁   锁膨胀
13. 锁消除

参考
1. [各种锁的分类](https://blog.csdn.net/a314773862/article/details/54095819)
