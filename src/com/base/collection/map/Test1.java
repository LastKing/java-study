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

    }
}
