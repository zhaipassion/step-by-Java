package com.books.book01.chapter06.AnonymousInnerClassTest;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;

/**
 * 【6.4.6】【匿名内部类】This program demonstrates anonymous inner classes.
 * 
 * @version 1.10 2004-02-27
 * @author Cay Horstmann
 */
public class AnonymousInnerClassTest {
	public static void main(String[] args) {
		TalkingClock clock = new TalkingClock();
		clock.start(1000, true);

		// keep program running until user selects "Ok"
		JOptionPane.showMessageDialog(null, "Quit program?");
		System.exit(0);
	}
}

class TalkingClock {
	public void start(int interval, final boolean beep) {
		ActionListener listener = new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				Date now = new Date();
				System.out.println("At the tone, the time is " + now);
				if (beep)
					Toolkit.getDefaultToolkit().beep();
			}
		};
		Timer t = new Timer(interval, listener);
		t.start();
	}
}

/**
 * 
 * HZ:
 * 声明匿名内部类的方法：在接口后面直接跟上花括号，里边写具体的方法就行了。所以，
 * 如果构造参数的闭圆括号跟一个花括号，正在定义的就是匿名内部类。
 * 一般内部类需要继承接口，匿名内部类不需要继承了，直接初始化接口名后面跟上具体实现。
 */

