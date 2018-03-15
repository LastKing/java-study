# HashMap学习总结

一片更加详细的各种Hash算法将key转化成int的文章[HashMap详解](http://www.hollischuang.com/archives/2091)<br/>
尚待解决的:
1. 容量capacity 和 负载因子load factor
1. HashMap中所有put和get方法的分析
2. 扩容（缩放）机制的具体实现原理
3. 1.8引入红黑树的机制，优势：
    1. 防止在数据极限碰撞的情况，出现O(1)退化成O(n)的劣势
    2. 将极限劣势的情况的O(n)进化成为O(logn)级别
4. 理解位运算在HashMap中的引用，意义优化速度操作
    1. (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
        这一句主要是 高位16bit和低位16bit异或，减少过少的位数造成的大量碰撞
    2. 	(n - 1) & hash  计算下标，防止下标越界
5. 为什么容量一定是2的n次方？
6. resize原理，load factor负载因子，capacity容量问题？
7. 红黑树的具体分析？

感觉以下三篇文章能解释了很多：
* [Java HashMap工作原理及实现](https://yikun.github.io/2015/04/01/Java-HashMap%E5%B7%A5%E4%BD%9C%E5%8E%9F%E7%90%86%E5%8F%8A%E5%AE%9E%E7%8E%B0/)
* [Java中HashMap底层实现原理(JDK1.8)源码分析](http://blog.csdn.net/tuke_tuke/article/details/51588156)
* [Jdk1.8中的HashMap实现原理](http://blog.csdn.net/fjse51/article/details/53811465)


## HashMap
实现原理：
1. 组成结构  Entry数组 + 链表
2. hashcode
    * old: key --> int ,int % 16=index
    * new: key -->int , int & 1111 效率更高
3. HashMap resize的条件 CurrentSize> Capacity * LoadFactor(default=0.75% 负载因子)
4. HashMap在进行Resize和ReHash的过程中多线程情况下会发生链的回环，在查询时发生死循环
5. HashTable和Collections.synchronizedMap能解决线程安全问题，但是性能较低，因为上来直接使用了悲观锁,
    当有操作时，读写都需要一个状态的所得这个所才能进行操作。
6. ConcurrentHashMap综合以上两点，进行了优化，采用了分支法，将hash层次进一步拆分，将增加了一层segment(实际也就一块Hash)
    两层的hash结构，采用局部自治，锁的粒度被细化，采用乐观锁，并不会锁定读的操作，只是局部锁定写的操作。

7. 尚待学习 理解透彻的 hash的一些细节，以及这个 ConcurrentHashMap中size的处理。。。。没明白。。。

**注意**此处的ConcurrentHashMap是分治法采用不同的区块不同加锁，增加效率，别和cas里面的思路弄混了。

**还有线程安全这一块，尚待彻底的学习和理解**

这个hash取模 <br/>
学习参考：
1. [漫画：什么是HashMap？](https://mp.weixin.qq.com/s?__biz=MzIxNjA5MTM2MA==&mid=2652434336&idx=1&sn=c808ecd7fd01e4caa779a767d0d16eb0&chksm=8c62102fbb1599393e372a5cf462462885fd899fe21cce2e5477e262396ba712f9374bc3a7d7&scene=21#wechat_redirect)
2. [深入HashMap上篇 （未看完）](https://www.cnblogs.com/softidea/p/7261111.html)
3. [漫画：什么是ConcurrentHashMap？](https://mp.weixin.qq.com/s?__biz=MzIxMjE5MTE1Nw==&mid=2653192083&idx=1&sn=5c4becd5724dd72ad489b9ed466329f5&chksm=8c990d49bbee845f69345e4121888ec967df27988bc66afd984a25331d2f6464a61dc0335a54&scene=21#wechat_redirect)


## HashTable
实现原理：
1. 组成结构 Entry数组 + 链表
2. 增加synchronized将代码同步化
3. 除非需要完全的数据一致性要求，否则尽量使用ConcurrentHashMap代替
