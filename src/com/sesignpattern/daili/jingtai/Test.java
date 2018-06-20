package com.sesignpattern.daili.jingtai;

import com.sesignpattern.daili.RealSubject;
import com.sesignpattern.daili.Subject;

/**
 * @author toonew on 2018/6/20
 */
public class Test {

    public static void main(String[] args) {
        Subject subject = new ProxySubject(new RealSubject());
        System.out.println(subject.visit());
        System.out.println(subject.visit());
    }

}
