package com.j8.lamdba;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * create by toonew on 2018/2/1
 */
public class Test2 {

    public static void main(String[] args) {

        //Java8之前：
        JButton show = new JButton("show");

        show.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Event handling without lambda expression is boring");
            }
        });

        //java8：
        show.addActionListener((e) -> {
            System.out.println("Light, Camera, Action !! Lambda expressions Rocks");
        });

    }

}
