package com.ltx.pattern.adapter;

/**
 * Created by toonew on 2017/1/20.
 */
public class NoteBook {
    private ThreePlugIf plug;

    public NoteBook(ThreePlugIf plug) {
        this.plug = plug;
    }

    public void charge() {
        plug.powerWithThree();
    }

    public static void main(String[] args) {
        GBTwoPlug two = new GBTwoPlug();
        ThreePlugIf plugIf = new TwoPlugAdapter(two);
        NoteBook nb= new NoteBook(plugIf);
        nb.charge();
    }

}
