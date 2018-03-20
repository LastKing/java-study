# set学习

## HashSet
底层有HashMap实现，真的感觉是把HashMap封装了，
不保证顺序，实际就是利用HashMap中key值不允许重复的特性。

## LinkedHashSet
继承自HashSet，仔细看HashSet中一个构造函数底层使用的是LinkedHashMap，
LinkedHashSet的顺序并保证不重复就是LinkedHashMap。

## TreeMap
底层由ThreeMap实现

## 总结
set真的没啥好写的，都是Map体系的一次应用。
