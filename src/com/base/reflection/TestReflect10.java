package com.base.reflection;


import java.lang.reflect.Array;

/**
 * 通过反射机制修改数组的大小
 * Created by Rain on 2017/2/27.
 */
public class TestReflect10 {

    public static void main(String[] args) throws Exception {
        int[] temp = {1, 2, 3, 4, 5};
        int[] newTemp = (int[]) arrayInc(temp, 15);
        print(newTemp);
        String[] atr = { "a", "b", "c" };
        String[] str1 = (String[]) arrayInc(atr, 8);
        print(str1);
    }

    public static Object arrayInc(Object obj, int length) {
        Class<?> arr = obj.getClass().getComponentType();
        Object newArr = Array.newInstance(arr, length);
        int co = Array.getLength(obj);
        System.arraycopy(obj, 0, newArr, 0, co);
        return newArr;
    }

    public static void print(Object obj) {
        Class<?> c = obj.getClass();
        if (!c.isArray()) {
            return;
        }
        System.out.println("数组长度：" + Array.getLength(obj));
        for (int i = 0; i < Array.getLength(obj); i++) {
            System.out.print(Array.get(obj, i) + " ");
        }
        System.out.println();
    }

}
