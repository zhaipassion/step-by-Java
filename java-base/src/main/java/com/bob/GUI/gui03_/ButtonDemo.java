package com.bob.GUI.gui03_;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ButtonDemo {
    private Frame f;
    private Button b;

    ButtonDemo() {
        init();
    }

    public void init() {
        f = new Frame("My frame");
        f.setBounds(300, 100, 600, 500);
        f.setLayout(new FlowLayout());

        b = new Button("MyButton");

        f.add(b);
        // 加载事件
        myEvent();
        f.setVisible(true);
    }

    private void myEvent() {
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.out.println("f.exit()");
                System.exit(0);
            }
        });

        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("B.exit()");
                System.exit(0);
            }
        });
    }


    public static void main(String[] args) {
        ButtonDemo d = new ButtonDemo();
        System.out.println(d);
    }
}
