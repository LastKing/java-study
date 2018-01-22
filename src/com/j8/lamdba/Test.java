package com.j8.lamdba;

public class Test {

    public static void main(String[] args) {

        Runnable r = () -> System.out.println("hello world");
        new Thread(r).start();


        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello world2");
            }
        };
        r2.run();

    }

}
