package com.ltx.init;

/**
 * 块的初始化
 * http://blog.csdn.net/qq_35101189/article/details/63680511
 * Created by Rain on 2017/3/20.
 */
public class Test {
    //静态初始块，static 定义，当类装在到系统试执行一次，
    static {
        System.out.println("In static initialization block!");//1
    }

    //非静态初始化块会在构造函数执行时,且在构造函数主体代码执行之前被运行.
    {
        System.out.println("In non-static initialization block!");//2
    }

    //两者的共同作用
    //初始化块是不能接收任何参数的，定义的一些所有对象共有的属性、方法等内容时就可以用初始化块了初始化！！

    public Test() {
        System.out.println("In Constructor1!"); //3
    }

    public void show() {
        System.out.println("In show()!");//4
    }

    public static void show2() {
        System.out.println("In show()!");//4
    }

    public static void main(String[] args) {
//        Test.show2();

        Test t1 = new Test();
        t1.show();
    }

}
