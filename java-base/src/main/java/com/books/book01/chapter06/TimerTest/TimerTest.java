package com.books.book01.chapter06.TimerTest;

/**
 * @version 1.00 2000-04-13
 * @author Cay Horstmann
 */

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;
import javax.swing.Timer;

// to resolve conflict with java.util.Timer

public class TimerTest {
    public static void main(String[] args) {
        ActionListener listener = new TimePrinter();

        // construct a timer that calls the listener
        // once every 10 seconds
        Timer t = new Timer(100, listener);
        t.start();

        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);
    }
}

// HZ：ActionListener一般是swing组件监听使用，，目前没有接触swing开发呢……
class TimePrinter implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent event) {
        Date now = new Date();
        System.out.println("At the tone, the time is " + now);
        // beep() 方法是用来发出 “嘟嘟声”
        Toolkit.getDefaultToolkit().beep();
    }
}
