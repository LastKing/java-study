package com.sesignpattern.daili.dongtai;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author toonew on 2018/6/20
 */
public class DynamicProxy implements InvocationHandler {
    private Object object;

    public DynamicProxy(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("日志开始");
        
        Object result = method.invoke(object, args);

        System.out.println("日志结束");

        return "dynamic 代理过的 name -- " + result;

    }
}
