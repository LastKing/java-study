package com.ltx.pattern.factory;

/**
 * Created by toonew on 2017/1/20.
 */
public class Test {
    public static void main(String[] args) {
//        HairInterface left = new LeftHair();
//        left.draw();

        HairFactory factory = new HairFactory();
        HairInterface right = factory.getHair("right");
        right.draw();

        System.out.println(LeftHair.class.getName());
        HairInterface left = factory.getHairByClass(LeftHair.class.getName());
        left.draw();
    }
}
