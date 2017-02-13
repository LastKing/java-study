package com.ltx.pattern.factory;

/**
 * Created by toonew on 2017/1/20.
 */
public class HairFactory {

    public HairInterface getHair(String key) {
        if ("left".equals(key)) {
            return new LeftHair();
        } else if ("right".equals(key)) {
            return new RightHair();
        }
        return null;
    }

    public HairInterface getHairByClass(String className) {
        try {
            HairInterface hairInterface = (HairInterface) Class.forName(className).newInstance();
            return hairInterface;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}
