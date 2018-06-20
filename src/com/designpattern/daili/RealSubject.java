package com.designpattern.daili;

/**
 * @author toonew on 2018/6/20
 */
public class RealSubject implements Subject {

    String name = "toonew-real1";

    @Override
    public String visit() {
        System.out.println("RealSubject -- name: " + name);
        return name;
    }

}
