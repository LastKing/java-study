package com.ltx.lifecycle;

/**
 * 被动引用
 * 引用父类的静态字段，只会引起父类的初始化，而不会引起子类的初始化。
 * 定义类数组，不会引起类的初始化。
 * 引用类的常量，不会引起类的初始化。
 * Created by Rain on 2017/2/28.
 */
public class Test3_beidong {
    public static void main(String[] args) {
        String a = SubInitClass3.a;// 引用父类的静态字段，只会引起父类初始化，而不会引起子类的初始化
        String b = InitClass3.b;// 使用类的常量不会引起类的初始化
        SubInitClass[] sc = new SubInitClass[10];// 定义类数组不会引起类的初始化
    }
}


class InitClass3 {
    static {
        System.out.println("初始化InitClass3");
    }

    public static String a = null;
    public final static String b = "b";

    public static void method() {
    }
}

class SubInitClass3 extends InitClass3 {
    static {
        System.out.println("初始化SubInitClass");
    }
}



