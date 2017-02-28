package com.base.collection.map;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Map
 * Created by toonew on 2017/2/23.
 */
public class Test1 {
    public static void main(String[] args) {
        Map map = new HashMap();//  HashMap非线程安全，高效，支持null；
        Map map2 = new Hashtable();//HashTable线程安全，低效，不支持null
        Map map3 = new LinkedHashMap();
    }
}
