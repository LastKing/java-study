package com.base.collection.set;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by toonew on 2017/2/23.
 */
public class Test1 {
    public static void main(String[] args) {
        Set set = new HashSet();  //(底层由HashMap实现)
        Set set2 = new LinkedHashSet();
        Set set3 = new TreeSet(); //SortedSet接口有一个实现类：TreeSet（底层由平衡二叉树实现）
    }
}
