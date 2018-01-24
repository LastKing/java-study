# HashMap学习总结

## HashMap
实现原理：
1. 组成结构  Entry数组 + 链表
2. hashcode
    * old:  key --> int ,int % 16=index
    * new: key -->int , int & 1111 效率更高
3. HashMap resize的条件 CurrentSize> Capacity * LoadFactor(default=0.75% 负载因子)
4. HashMap在进行Resize和ReHash的过程中多线程情况下会发生链的回环，在查询时发生死循环
5. HashTable和Collections.synchronizedMap能解决线程安全问题，但是性能较低，因为上来直接使用了悲观锁,
    当有操作时，读写都需要一个状态的所得这个所才能进行操作。
6. ConcurrentHashMap综合以上两点，进行了优化，采用了分支法，将hash层次进一步拆分，将增加了一层segment(实际也就一块Hash)
    两层的hash结构，采用局部自治，锁的粒度被细化，采用乐观锁，并不会锁定读的操作，只是局部锁定写的操作。

7. 尚待学习 理解透彻的 hash的一些细节，以及这个 ConcurrentHashMap中size的处理。。。。没明白。。。

**还有线程安全这一块，尚待彻底的学习和理解**

这个hash取模 <br/>
学习参考：
1. [漫画：什么是HashMap？](https://mp.weixin.qq.com/s?__biz=MzIxNjA5MTM2MA==&mid=2652434336&idx=1&sn=c808ecd7fd01e4caa779a767d0d16eb0&chksm=8c62102fbb1599393e372a5cf462462885fd899fe21cce2e5477e262396ba712f9374bc3a7d7&scene=21#wechat_redirect)
2. [深入HashMap上篇 （未看完）](https://www.cnblogs.com/softidea/p/7261111.html)
3. [漫画：什么是ConcurrentHashMap？](https://mp.weixin.qq.com/s?__biz=MzIxMjE5MTE1Nw==&mid=2653192083&idx=1&sn=5c4becd5724dd72ad489b9ed466329f5&chksm=8c990d49bbee845f69345e4121888ec967df27988bc66afd984a25331d2f6464a61dc0335a54&scene=21#wechat_redirect)
