package com.ltx.strings;

/**
 * 出处： http://www.jianshu.com/p/c92578398114
 * Created by Rain on 2017/2/28.
 */
public class String1 {

    private static void test1() {
        //直接赋一个字面量
        /*
          最多创建一个String对象,最少不创建String对象.
          如果常量池中,以及存在”hello toby”,那么str直接引用,此时不创建String对象.
          否则,先在常量池先创建”hello toby”内存空间,再引用.
         */
        String str = "hello toby";

        //通过构造器创建
        /*
         * 最多创建两个String对象,至少创建一个String对象.
         * new关键字:绝对会在堆空间,创建内存区域. 所以至少创建一个String个对象.
         * 假如常量池没有,则会在常量池先创建,后引用,所以最多创建两个对象
         */
        String str2 = new String("hello toby");
    }


    private static String getString() {
        return "AB";
    }

    private static void test2() {
        //一下String 对象是否相等
        String str1 = "ABCD";
        String str2 = "A" + "B" + "C" + "D";
        String str3 = "AB" + "CD";
        String str4 = new String("ABCD");
        String temp = "AB";
        String str5 = temp + "CD";
        String str6 = getString() + "CD";
        System.out.println(str1 == str2);//true
        System.out.println(str1 == str3);//true
        System.out.println(str1 == str4);//false
        System.out.println(str1 == str5);//false
        System.out.println(str1 == str6);//false
    }

    private static void test3() {
        //String是内容不可变的字符串,StringBuffer是内容可变的字符串,当你知道字符串的内容要改变的时候,
        // 使用StringBuffer性能比String高. StringBuffer默认只能存储16个字符,所以要提高性能,
        // 可以在初始化的时候给一个初始大小.

        String str = "1";
        StringBuffer sb = new StringBuffer("hello");
        System.out.println(str.hashCode());
        System.out.println(sb.hashCode());
        str += "2";
        System.out.println(str.hashCode());
        sb.append("ets");
        System.out.println(sb.hashCode());
    }

    private static void test4(){
        //都是可变字符串
        StringBuffer sb=new StringBuffer(); //线程安全
        StringBuilder sbuilder=new StringBuilder();//线程不安全
    }


    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }
}
