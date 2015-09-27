package com.bob.GUI.gui02_EventAndListener;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 事件监听机制的特点：
 * 1、事件源：就是awt包或者swing包中的那些图形界面组件
 * 2、事件：每一个事件源都有自己特有的对应事件和共性事件
 * 3、监听器：将可以触发某一个事件的动作（不止一个）都已经封装到了监听器中
 * 4、事件处理
 * <p>
 * 我们要做的就是对产生的动作进行处理
 *
 * @author Haizhu
 */
public class EventAndListener_Demo {
    public static void main(String[] args) {
        Frame f = new Frame("My first awt");
        f.setVisible(true);
        f.setLocation(500, 200);
        f.setSize(500, 300);
        f.setLayout(new FlowLayout());
        Button b = new Button("This is a button");
        f.add(b);
        /**
         * 添加监听
         */
        //f.addWindowListener(new MyWinLis());
        /**
         * 添加监听的另一种方式：匿名内部类
         */
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }

            public void windowActivated(WindowEvent e) {
                System.out.println("windowActived.....");
            }

            public void windowOpened(WindowEvent e) {
                System.out.println("windowOpened......");
            }
        });
    }
}

class MyWinLis extends WindowAdapter {
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }
}

