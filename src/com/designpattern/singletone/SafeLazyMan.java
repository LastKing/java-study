package com.designpattern.singletone;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 懒汉线程安全
 * 出处： https://github.com/pzxwhc/MineKnowContainer/issues/74
 * 为什么要用volatile : http://wuchong.me/blog/2014/08/28/how-to-correctly-write-singleton-pattern/
 * Created by toonew on 2017/3/1.
 */
public class SafeLazyMan {
    private static volatile SafeLazyMan safeLazyMan;//保证操作的可见性，禁止执行重排
    private static Lock lock = new ReentrantLock();

    private SafeLazyMan() {
    }

    public synchronized static SafeLazyMan getSingleton() {
        if (safeLazyMan == null) {
            lock.lock();
            try {
                if (safeLazyMan == null) {
                    safeLazyMan = new SafeLazyMan();
                }
            } finally {
                lock.unlock();
            } //或者用synchronized实现
        }
        return safeLazyMan;
    }

}
