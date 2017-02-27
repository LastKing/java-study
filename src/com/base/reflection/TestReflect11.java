package com.base.reflection;

/**
 * 将反射机制应用于工厂模式
 * Created by Rain on 2017/2/27.
 */
interface Fruit {
    public abstract void eat();
}

class Apple implements Fruit {
    @Override
    public void eat() {
        System.out.println("Apple");
    }
}

class Orange implements Fruit {
    public void eat() {
        System.out.println("Orange");
    }
}

class Factory {
    public static Fruit getInstance(String ClassName) {
        Fruit f = null;
        try {
            f = (Fruit) Class.forName(ClassName).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }
}

public class TestReflect11 {
    public static void main(String[] args) {
        Fruit f = Factory.getInstance("com.base.reflection.Apple");
        Fruit f2 = Factory.getInstance("com.base.reflection.Orange");
        f.eat();
        f2.eat();
    }

}
