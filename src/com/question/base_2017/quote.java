package com.question.base_2017;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * create by toonew on 2018/1/30
 */
public class quote {
    public static void main(String[] args) throws Exception {
        //1. 强引用
        Object obj = new Object();

        System.out.println("===========软引用============");
        //2. 软银用
        soft();

        System.out.println("===========弱引用============");
        //3. 弱引用
        weak();

        //4. 虚引用
        xu();
    }

    /**
     * 只有当内存不够的时候，才回收这类内存，因此在内存足够的时候，
     * 它们通常不被回收 无论是否发送GC,执行结果都是:
     * java.lang.Object@f9f9d8 * null * java.lang.Object@f9f9d8 * null
     * 可以看到:只有发送了GC,将对于从内存中释放的时候,JVM才会将reference加入引用队列
     */
    private static void soft() throws Exception {
        Object obj = new Object();
        ReferenceQueue<Object> refQueue = new ReferenceQueue<>();
        SoftReference<Object> softRef = new SoftReference<>(obj, refQueue);
        System.out.println(softRef.get());
        // java.lang.Object@f9f9d8
        System.out.println(refQueue.poll());// null
        // 清除强引用,触发GC
        obj = null;
        System.gc();
        System.out.println(softRef.get());
        Thread.sleep(200);
        System.out.println(refQueue.poll());
    }

    /**
     * 弱引用: 当发生GC的时候,Weak引用对象总是会内回收回收。因此Weak引用对象会更容易、更快被GC回收。
     * Weak引用对象常常用于Map数据结构中，引用占用内存空间较大的对象
     * 如果不发生垃圾回收：
     * java.lang.Object@f9f9d8 * null * java.lang.Object@f9f9d8 * null *
     * 如果发生垃圾回收:
     * java.lang.Object@f9f9d8 * null * null * java.lang.ref.WeakReference@422ede * *
     */
    private static void weak() throws Exception {
        Object obj = new Object();
        ReferenceQueue<Object> refQueue = new ReferenceQueue<>();
        WeakReference<Object> weakRef = new WeakReference<>(obj, refQueue);
        System.out.println(weakRef.get()); // java.lang.Object@f9f9d8
        System.out.println(refQueue.poll());// null
        // 清除强引用,触发GC
        obj = null;
        System.gc();
        System.out.println(weakRef.get());
        // 这里特别注意:poll是非阻塞的,remove是阻塞的.
        // JVM将弱引用放入引用队列需要一定的时间,所以这里先睡眠一会儿
        System.out.println(refQueue.poll());// 这里有可能是null
        Thread.sleep(200);
        System.out.println(refQueue.poll());
        System.out.println(refQueue.poll());//这里一定是null,因为已经从队列中移除
        System.out.println(refQueue.remove());
    }

    /**
     * 当GC一但发现了虚引用对象，将会将PhantomReference对象插入ReferenceQueue队列.
     * 而此时PhantomReference所指向的对象并没有被GC回收，而是要等到ReferenceQueue被你真正的处理后才会被回收.
     * 这里特别需要注意：当JVM将虚引用插入到引用队列的时候，虚引用执行的对象内存还是存在的。
     * 但是PhantomReference并没有暴露API返回对象。所以如果我想做清理工作，
     * 需要继承PhantomReference类，以便访问它指向的对象。
     * 如NIO直接内存的自动回收，就使用到了sun.misc.Cleaner
     */
    private static void xu() {
        System.out.println("虚引用");
    }
}
