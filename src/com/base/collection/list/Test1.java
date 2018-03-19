package com.base.collection.list;

import java.util.*;

/**
 * List
 * Created by toonew on 2017/2/23.
 */
public class Test1 {
    public static void main(String[] args) {
        //ArrayList是非线程安全的，效率高   （顺序存储）
        List list = new ArrayList();

        //Vector   是synchronized实现的线程安全，效率低 （以上两者都是 数组的动态扩容实现的）
        List list2 = new Vector();
        List list4 = Collections.synchronizedList(list);

        //LinkedList：底层基于链表实现，链表内存是散乱的，
        // 每一个元素存储本身内存地址的同时还存储下一个元素的地址。链表增删快，查找慢
        List list3 = new LinkedList();
    }
}
