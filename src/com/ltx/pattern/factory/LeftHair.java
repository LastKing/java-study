package com.ltx.pattern.factory;

/**
 * Created by toonew on 2017/1/20.
 */
public class LeftHair implements HairInterface {
    @Override
    public void draw() {
        System.out.println("左偏分");
    }
}
