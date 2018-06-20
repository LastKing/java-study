package com.sesignpattern.daili.jingtai;

import com.sesignpattern.daili.Subject;

/**
 * 这是个最简单的代理，试着增加一些功能
 * <p>
 * 比如增加
 * 1. 日志功能，这样就可以不用再每一个 visit 上都日志
 * 2. 缓存功能，如果visit有输入并且会进行固定运算，可以在visit上进行缓存操作,增加一个HashMap 用来缓存啥的
 *
 * @author toonew on 2018/6/20
 */
public class ProxySubject implements Subject {
    private Subject subject;

    public ProxySubject(Subject subject) {
        this.subject = subject;
    }

    @Override
    public String visit() {
        try {
            System.out.println("日志开始");

            return "静态代理过的 -- name  " + subject.visit();
        } finally {
            System.out.println("日志结束");
        }
    }
}
