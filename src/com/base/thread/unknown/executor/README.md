# 线程与执行器

## Thread 和 Runnable 的关系
基本实现和使用方式

## Executor 执行器基本api


### scheduleAtFixedRate vs scheduleWithFixedDelay
scheduleAtFixedRate
```
00:00: Start making coffee
00:10: Finish making coffee
01:00: Start making coffee
01:10: Finish making coffee
02:00: Start making coffee
02:10: Finish making coffee
```

scheduleWithFixedDelay
```
00:00: Start making coffee
00:10: Finish making coffee
01:10: Start making coffee
01:20: Finish making coffee
02:20: Start making coffee
02:30: Finish making coffee
```
[此处对比出处StackOverFlow](https://stackoverflow.com/questions/24649842/scheduleatfixedrate-vs-schedulewithfixeddelay)


参考：
1. [线程和执行器](https://zhuanlan.zhihu.com/p/33266682?utm_source=qq&utm_medium=social)