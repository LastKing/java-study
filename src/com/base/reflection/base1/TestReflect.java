package com.base.reflection.base1;

/**
 * 出处：http://www.cnblogs.com/lzq198754/p/5780331.html
 * Created by Rain on 2017/2/27.
 */
public class TestReflect {

    public static void main(String[] args) throws Exception {
        Class<?> class1 = null;
        Class<?> class2 = null;
        Class<?> class3 = null;

        class1 = Class.forName("com.base.reflection.base1.TestReflect");
        class2 = new TestReflect().getClass();
        class3 = TestReflect.class;

        System.out.println("类名称   " + class1.getName());
        System.out.println("类名称   " + class2.getName());
        System.out.println("类名称   " + class3.getName());

    }


}
