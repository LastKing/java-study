package com.ltx.pattern.adapter;

/**
 * Created by toonew on 2017/1/20.
 */
public class TwoPlugAdapter implements ThreePlugIf {
    private GBTwoPlug plug;

    public TwoPlugAdapter(GBTwoPlug plug) {
        this.plug = plug;
    }

    @Override
    public void powerWithThree() {
        System.out.println("三转二");
        plug.powerWithTwo();
    }
}
