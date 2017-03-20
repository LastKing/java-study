package com.base.enums;

/**
 * 枚举实例
 * Created by Rain on 2017/2/28.
 */
public class TestColor {

    public static void main(String[] args) {
        System.out.println(isRed(Color.BLANK));
        System.out.println(isRed(Color.RED));

        showColor(Color.BLANK);

        System.out.print(Color.BLANK.getName());
        System.out.println(Color.BLANK.getIndex());

        for (Color color : Color.values()) {
            System.out.println(color + " name: " + color.getName() + " index: " + color.getIndex());
        }
    }

    static boolean isRed(Color color) {
        return Color.RED.equals(color);
    }

    static void showColor(Color color) {
        switch (color) {
            case BLANK:
                System.out.println(color);
                break;
            case RED:
                System.out.println(color);
                break;
            default:
                System.out.println(color);
                break;
        }
    }
}
