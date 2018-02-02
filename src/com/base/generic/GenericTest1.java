package com.base.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rain on 2017/2/27.
 */
public class GenericTest1 {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("list -- 1");
        list.add("list -- 2");
        list.add(100);


        // java.lang.Integer cannot be cast to java.lang.String
        try {
            for (Object aList : list) {
                String name = (String) aList; // 1
                System.out.println("name:" + name);
            }
        } catch (Exception err) {
            err.printStackTrace();
        }


        List<String> list2 = new ArrayList<>();
        list2.add("list2 -- 1");
        list2.add("list2 -- 2");
//        list2.add(100); //编译错误
        for (String aList : list2) {
            System.out.println("name:" + aList);
        }

    }

}
