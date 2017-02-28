package com.base.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rain on 2017/2/27.
 */
public class GenericTest1 {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("qqyumidi");
        list.add("corn");
        list.add(100);

        // java.lang.Integer cannot be cast to java.lang.String
//        for (Object aList : list) {
//            String name = (String) aList; // 1
//            System.out.println("name:" + name);
//        }

        List<String> list2 = new ArrayList<>();
        list2.add("qqyumidi");
        list2.add("corn");
//        list2.add(100); //编译错误
        for (String aList : list2) {
            System.out.println("name:" + aList);
        }

    }

}
