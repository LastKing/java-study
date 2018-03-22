package com.base.thread.synchronizeds.demo;

/**
 * 同步静态方法
 * create by toonew on 2018/3/22
 */
public class Test6 {

    public static void main(String[] args) {
        ThreadA a = new ThreadA();
        a.setName("A");
        a.start();

        ThreadB b = new ThreadB();
        b.setName("B");
        b.start();
    }

}

class Service {
    synchronized public static void printA() {
        try {
            System.out.println("线程名称为：" + Thread.currentThread().getName()
                    + "在" + System.currentTimeMillis() + "进入printA");
            Thread.sleep(3000);
            System.out.println("线程名称为：" + Thread.currentThread().getName()
                    + "在" + System.currentTimeMillis() + "离开printA");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized public static void printB() {
        System.out.println("线程名称为：" + Thread.currentThread().getName() + "在"
                + System.currentTimeMillis() + "进入printB");
        System.out.println("线程名称为：" + Thread.currentThread().getName() + "在"
                + System.currentTimeMillis() + "离开printB");
    }
}

class ThreadA extends Thread {
    @Override
    public void run() {
        Service.printA();
    }
}

class ThreadB extends Thread {
    @Override
    public void run() {
        Service.printB();
    }
}