package com.bob.collection_Demo.c02_List;

import java.util.Enumeration;
import java.util.Vector;

/**
 * Vector 是 java1.0开始的，ArrayList 是 java1.2开始的，
 * 所以Vector逐步被ArrayList取代了，但是此类最主要的一个作用是
 * 获取枚举（Enumeration），而枚举和迭代是一样的，因为枚举的名称
 * 以及方法的名称过长，所以枚举被迭代器取代了。
 * @author Haizhu
 */
public class list03_Vector {
	public static void main(String[] args) {
		Vector<String> v = new Vector<String>();
		v.add("v01");
		v.add("v02");
		v.add("v03");
		Enumeration<String> en = v.elements();
		while(en.hasMoreElements()){
			System.out.println(en.nextElement());
		}
	}
}
