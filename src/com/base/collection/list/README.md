# list 相关学习

主要三种
ArrayList Vector LinkList

## ArrayList
1. [ArrayList几问](https://zhuanlan.zhihu.com/p/34301705?utm_source=wechat_session&utm_medium=social)

问题：
1. ArrayList是线程安全么？如果不是为什么？有哪些场景？
答案：不是，[具体场景参见](http://blog.csdn.net/u012859681/article/details/78206494)
简化描述，
一种是同时开启检测，结果都增加，导致最后数组越界，
另一种因为非原子操作，导致两次操作都set到同一个index，但是size增加了n


## Vector
ArrayList的同步版本

## LinkList
这个好像不错，但是我不懂双向链表，先看双向链表https://www.cnblogs.com/skywang12345/p/3308807.html


