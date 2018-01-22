# HashMap学习总结

## HashMap
实现原理：
1. 组成结构  Entry数组 + 链表
2. hashcode
    * old:  key --> int ,int % 16=index
    * new: key -->int , int & 1111 效率更高
3. 还有线程安全这一块，未查找或者理解相关的资料

这个hash取模 <br/>
学习参考：
1. [漫画：什么是HashMap？](https://mp.weixin.qq.com/s?__biz=MzIxNjA5MTM2MA==&mid=2652434336&idx=1&sn=c808ecd7fd01e4caa779a767d0d16eb0&chksm=8c62102fbb1599393e372a5cf462462885fd899fe21cce2e5477e262396ba712f9374bc3a7d7&scene=21#wechat_redirect)
2. [深入HashMap上篇 （未看完）](https://www.cnblogs.com/softidea/p/7261111.html)




