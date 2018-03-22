# synchronized 关键字的学习

## synchronized 作为同步代码块 时的效果
1. 当两个并发线程访问同一个对象object中的这个synchronized(this)同步代码块时，一个时间内只能有一个线程得到执行。
另一个线程必须等待当前线程执行完这个代码块以后才能执行该代码块。
2. 当一个线程访问object的一个synchronized(this)同步代码块时，另一个线程仍然可以访问该object中的非synchronized(this)同步代码块。
3. 当一个线程访问object的一个synchronized(this)同步代码块时，其他线程对object中所有其它synchronized(this)同步代码块的访问将被阻塞。
4. 当一个线程访问object的一个synchronized(this)同步代码块时，它就获得了这个object的对象锁。
结果，其它线程对该object对象所有**同步代码部分**的访问都被暂时阻塞。（这里指的是同步方法等。。）
5. 以上规则对其他对象锁同样适用

以上案例看demo文件夹。这个例子没有讲好同步静态方法[出处](http://www.cnblogs.com/GnagWang/archive/2011/02/27/1966606.html#!comments)

## synchronized 各种锁定状态
http://www.importnew.com/21866.html <br/>
https://blog.csdn.net/u013142781/article/details/51697672 <br/>
https://www.jianshu.com/p/ea9a482ece5f

1. synchronized(this)
2. synchronized(instance)   不明白有一种写法synchronized(任意byte[] ,String)有什么意义
3. synchronized method
4. synchronized static method
5. synchronized (Xxxx.Class)
6. synchronized (Class.forName("Xxxx"))

对象锁(1,2,3)和类锁(4,5,6)

对象锁：每个实例对象有一把锁，当线程要访问任意一个synchronized方法时，只有获得这把锁才能调用该synchronized方法，
其他线程要执行synchronized方法时，不论是否和上一个方法是同一个方法，都需要获得锁才能进行操作。

类锁：如果获得类锁，类上所有的操作都会被锁定，需要等待类锁释放才能给后面的线程使用。

类锁和对象锁可以同时获得