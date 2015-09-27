package com.haizhu.GUI_Demo.gui01_Inotroduction;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;

public class Frame_Demo {

	/**
	 * 新开的窗口是由另外的线程设定的。
	 * @param args
	 */
	public static void main(String[] args) {
		Frame f = new Frame("My first awt");
		/**
		 * 设置为可见
		 */
		f.setVisible(true);
		/**
		 * 设置位置
		 */
		f.setLocation(500, 200);
		f.setSize(500, 300);
		/**
		 * 布局方式
		 */
		f.setLayout(new FlowLayout());
		/**
		 * 添加按钮
		 */
		Button b = new Button("This is a button");
		f.add(b);
		
		System.out.println("Hello world!");
	}
}
