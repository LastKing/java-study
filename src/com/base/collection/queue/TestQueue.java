package com.base.collection.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 队列初体验
 * Created by Rain on 2017/2/23.
 */
public class TestQueue {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();

        queue.offer("hello");
        queue.offer("world");
        queue.offer("你好");

        System.out.println(queue.size());

        String str;
        while ((str = queue.poll()) != null) {
            System.out.println(str);
        }
        System.out.println();
        System.out.println(queue.size());
    }
}
