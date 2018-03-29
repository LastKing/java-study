package base.reflection.base1;

import java.lang.reflect.Constructor;

/**
 * 获取某个类中的全部构造函数
 * 通过反射机制实例化一个类的对象
 * Created by Rain on 2017/2/27.
 */
public class TestReflect3 {

    public static void main(String[] args) throws Exception {
        Class<?> class1 = null;
        class1 = Class.forName("base.reflection.base1.User");

        // 第一种方法，实例化默认构造方法，调用set赋值
        User user = (User) class1.newInstance();
        user.setAge(20);
        user.setName("Rollen");

        System.out.println(user);

        // 第二种方法 取得全部的构造函数 使用构造函数赋值
        Constructor<?> cons[] = class1.getConstructors();

        for (int i = 0; i < cons.length; i++) {
            Class<?> clazzs[] = cons[i].getParameterTypes();
            System.out.println("cons[ " + i + " ] (");
            for (int j = 0; j < clazzs.length; j++) {
                if (j == clazzs.length - 1)
                    System.out.print(clazzs[j].getName());
                else
                    System.out.print(clazzs[j].getName() + ",");
            }
            System.out.println(")");
        }

    }


}
