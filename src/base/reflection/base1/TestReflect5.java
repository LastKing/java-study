package base.reflection.base1;

import java.lang.reflect.Method;

/**
 * 通过反射机制调用某个类的方法
 * Created by Rain on 2017/2/27.
 */
public class TestReflect5 {

    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("base.reflection.base1.TestReflect5");
        // 调用TestReflect类中的reflect1方法
        Method method = clazz.getMethod("reflect1");
        method.invoke(clazz.newInstance());
        method = clazz.getMethod("reflect2", int.class, String.class);
        method.invoke(clazz.newInstance(), 20, "张三");
    }

    public void reflect1() {
        System.out.println("Java 反射机制 - 调用某个类的方法1.");
    }

    public void reflect2(int age, String name) {
        System.out.println("Java 反射机制 - 调用某个类的方法2.");
        System.out.println("age -> " + age + ". name -> " + name);
    }

}
