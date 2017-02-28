package com.base.collection.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

/**
 * List
 * Created by toonew on 2017/2/23.
 */
public class Test1 {
    public static void main(String[] args) {
        //ArrayList是非线程安全的，效率高
        List list = new ArrayList();
        list.add(0,"dfas");
        System.out.println(list.size());
        //Vector是基于线程安全的，效率低
        List list2 = new Vector();

        //LinkedList：底层基于链表实现，链表内存是散乱的，
        // 每一个元素存储本身内存地址的同时还存储下一个元素的地址。链表增删快，查找慢
        List list3 = new LinkedList();
    }
}
