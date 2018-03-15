package com.base.collection.map;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Map
 * Created by toonew on 2017/2/23.
 */
public class Test1 {
    public static void main(String[] args) {
        Map map = new HashMap();//  HashMap非线程安全，高效，支持null；

        //二者存为集合锁
        Map map2 = new Hashtable();//HashTable线程安全，低效，不支持null
        Map map5 = Collections.synchronizedMap(map);//线程安全，会锁定表其他线程的一切操作

        //集合楼上 三者的折中点
        Map map6 = new ConcurrentHashMap(); //两层hash，细化锁得层级

        Map map3 = new LinkedHashMap();
        Map map4 = new TreeMap();

        System.out.println(tableSizeFor(18));
    }

    static final int tableSizeFor(int cap) {
        int MAXIMUM_CAPACITY = 1 << 30;
        int n = cap - 1;//0001 0001
        n |= n >>> 1;   //0000 1000  0001 1001
        n |= n >>> 2;   //           0000 0110  0001 1111
        n |= n >>> 4;   //                      0000 0001 0001 1111
        n |= n >>> 8;   //                                0001 1111
        n |= n >>> 16;  //                                0001 1111
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }

}
