package com.base.reflection.base1;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * 反射机制的应用实例
 * 在泛型为Integer的ArrayList中存放一个String类型的对象。
 * Created by Rain on 2017/2/27.
 */
public class TestReflect8 {

    public static void main(String[] args) throws Exception {
        List<Integer> list = new ArrayList<>();

        Method method = list.getClass().getMethod("add", Object.class);

        method.invoke(list, "Java反射机制实例");
        System.out.println(list.get(0));

    }


}
