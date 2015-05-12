package com.books.book01.chapter06.LocalInnerClassTest;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;

/**
 * 【6.4.4】【局部内部类】This program demonstrates the use of local inner classes.
 * 
 * @version 1.00 2004-02-27
 * @author Cay Horstmann
 */
public class LocalInnerClassTest {
	public static void main(String[] args) {
		TalkingClock clock = new TalkingClock();
		clock.start(1000, true);

		JOptionPane.showMessageDialog(null, "Quit program?");
		System.exit(0);
	}
}

class TalkingClock {
	public void start(int interval, final boolean beep) {
		class TimePrinter implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				Date now = new Date();
				System.out.println("At the tone, the time is " + now);
				if (beep)
					Toolkit.getDefaultToolkit().beep();
			}
		}
		ActionListener listener = new TimePrinter();
		Timer t = new Timer(interval, listener);
		t.start();
	}
}
