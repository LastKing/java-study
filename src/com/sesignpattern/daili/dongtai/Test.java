package com.sesignpattern.daili.dongtai;

import com.sesignpattern.daili.RealSubject;
import com.sesignpattern.daili.Subject;

import java.lang.reflect.Proxy;

/**
 * 动态代理 解决了 静态代理  里面批量操作的问题，减少了重复说些 同样的代理方法的逻辑
 *
 * @author toonew on 2018/6/20
 */
public class Test {

    public static void main(String[] args) {

        Subject realSubject = new RealSubject();
        DynamicProxy proxy = new DynamicProxy(realSubject);
        ClassLoader classLoader = realSubject.getClass().getClassLoader();

        /*
         * 牛逼。。代理模式 牛逼。。。
         * 下面这个 new 一个新的代理 什么意思类，我的理解就是
         * 创建一个新的代理对象，
         * 第一个参数 表明  那个对象需要被代理
         * 第二个参数 表明  那些接口或者方法需要被代理 （被代理的对象可能实现了多个接口）
         * 第三个参数 表明  使用什么代理，代理到做了些什么，比如 增加了 日志，事务，缓存？或者其他的？
         */
        Subject subject = (Subject) Proxy.newProxyInstance(classLoader, new Class[]{Subject.class}, proxy);
        System.out.println(subject.visit());
    }

}
