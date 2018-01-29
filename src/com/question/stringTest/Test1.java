package com.question.stringTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by toonew on 2017/3/7.
 */
public class Test1 {

    public static void main(String[] args) throws Exception {
        Thread.sleep(100);
        List<String> list = new ArrayList<>(4000);
        StringBuilder sb = new StringBuilder("prex");

        Date d1 = new Date();
        for (int i = 0; i < 4000; i++) {
            sb.append(i);
            list.add(sb.toString());
        }
        Date d2 = new Date();
        System.out.println(d2.getTime() - d1.getTime());

        Date start2 = new Date();
        List<String> list2 = new ArrayList<>();
        String prex2 = "prex";
        for (int i = 0; i < 4000; i++) {
            String s = prex2 + i;
            list2.add(s);
        }
        Date end2 = new Date();
        System.out.println(end2.getTime() - start2.getTime());

    }

}