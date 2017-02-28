package com.ltx.lifecycle;

/**
 * 类的初始化 过程
 * 按照顺序  自上而下  运行类中的  变量赋值语句 和 静态语句，
 * 如果有父类，则首先将父类中的变量赋值语句和静态语句按照顺序运行
 * Created by Rain on 2017/2/28.
 */
public class Test2_ShunXu {
    // 在类的初始化阶段，只会初始化与类相关的静态赋值语句和静态语句，
    // 也就是有static关键字修饰的信息，而没有static修饰的赋值语句和执行语句在实例化对象的时候才会运行。
    public static void main(String[] args) {
        new SubInitClass2();   //1  最开始主函数
    }
}

class Field1 {
    public Field1() {
        System.out.println("Field1构造方法"); //3 因为InitClass2中new了 Field1
    }
}

class Field2 {
    public Field2() {
        System.out.println("Field2构造方法"); //5
    }
}

class InitClass2 {
    static {
        System.out.println("运行父类静态代码"); //2 优先初始化 父类，因为SubInitClass2集成了InitClass2
    }

    public static Field1 f1 = new Field1();  //4
    public static Field1 f2;
}

class SubInitClass2 extends InitClass2 {
    static {
        System.out.println("运行子类静态代码"); //5
    }

    public static Field2 f2 = new Field2(); //6
}