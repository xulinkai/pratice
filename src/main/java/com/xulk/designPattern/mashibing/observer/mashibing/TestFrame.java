package com.xulk.designPattern.mashibing.observer.mashibing;

import sun.awt.WindowClosingListener;

import java.awt.*;
import java.awt.event.*;

/**
 * @description:
 * @author:
 * @create: 2019-09-05 22:45
 **/
public class TestFrame extends Frame{

    public void lanunch() {
        Button button = new Button("presse me");
        button.addActionListener(new MyActionListener());
        button.addActionListener(new MyActionListener1());
        this.add(button);
        this.pack();
        this.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
            }

            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }

            @Override
            public void windowClosed(WindowEvent e) {
            }

            @Override
            public void windowIconified(WindowEvent e) {
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
            }

            @Override
            public void windowActivated(WindowEvent e) {
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
            }
        });
        button.setLocation(500, 500);
        this.setVisible(true);

    }

    public static void main(String[] args) {
        new TestFrame().lanunch();
    }

    private class MyActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("button pressed !");
        }
    }

    private class MyActionListener1 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("button pressed 2 !");
        }
    }
}
