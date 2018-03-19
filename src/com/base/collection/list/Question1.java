package com.base.collection.list;

import java.util.ArrayList;
import java.util.List;

/**
 * arrayList为什么不安全
 * http://blog.csdn.net/u012859681/article/details/78206494
 * create by toonew on 2018/3/19
 */
public class Question1 {

    public static void main(String[] args) throws Exception {
        final List<Integer> list = new ArrayList<>();

        // 线程A将0-1000添加到list
        new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    list.add(i);

                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        // 线程B将1000-2000添加到列表
        new Thread(new Runnable() {
            public void run() {
                for (int i = 1000; i < 2000; i++) {
                    list.add(i);

                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        Thread.sleep(2000);

        // 打印所有结果
        for (int i = 0; i < list.size(); i++) {
            System.out.println("第" + (i + 1) + "个元素为：" + list.get(i));
        }
        System.out.println(list.size());
    }

}
