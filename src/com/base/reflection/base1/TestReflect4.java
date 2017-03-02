package com.base.reflection.base1;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * 获取某个类的全部属性
 * Created by Rain on 2017/2/27.
 */
public class TestReflect4 implements Serializable {
    private static final long serialVersionUID = -2862585049955236662L;

    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("com.base.reflection.base1.TestReflect4");

        System.out.println("=================本类属性==================");

        //取得本类的全部属性
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            //权限修饰符
            int mo = field.getModifiers();
            String priv = Modifier.toString(mo);
            //属性类型
            Class<?> type = field.getType();
            System.out.println(priv + " " + type.getName() + " " + field.getName() + ";");
        }

        System.out.println("==========实现的接口或者父类的属性==========");
        Field[] parentFields = clazz.getFields();
        for (Field parentField : parentFields) {
            int mo = parentField.getModifiers();
            String priv = Modifier.toString(mo);

            Class<?> type = parentField.getType();
            System.out.println(priv + " " + type.getName() + " " + parentField.getName() + ";");
        }
    }


}
