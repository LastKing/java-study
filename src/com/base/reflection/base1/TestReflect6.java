package com.base.reflection.base1;

import java.lang.reflect.Field;

/**
 * 通过反射机制操作某个类的属性
 * Created by Rain on 2017/2/27.
 */
public class TestReflect6 {
    private String proprety = "test";

    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("com.base.reflection.base1.TestReflect6");

        Object obj = clazz.newInstance();

        Field field = clazz.getDeclaredField("proprety");
        //当然在TestReflect6类的内部(TestReflect6的内部类除外)，进行如上操作则不需要调用setAccesible()方法）
        field.setAccessible(true); //AccessibleTest类中的成员变量为private,故必须进行此操作
        field.set(obj, "Java反射机制");//获取当前对象中当前Field的value
        System.out.println(field.get(obj));
    }


}
