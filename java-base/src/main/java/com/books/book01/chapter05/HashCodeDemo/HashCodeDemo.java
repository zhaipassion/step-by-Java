package com.books.book01.chapter05.HashCodeDemo;

/**
 * @ClassName: HashCodeDemo
 * @Description:
 * @author HZ
 * @date 2015年2月15日 下午5:15:58
 */
public class HashCodeDemo {
	public static void main(String[] args) {

		stringHashCode();

		stringBuilderHashCode();
	}

	private static void stringBuilderHashCode() {
		/**
		 * 
		 */
		String s = "OK";
		StringBuilder sb = new StringBuilder(s);
		System.out.println(s.hashCode() + "  " + sb.hashCode());
		String t = new String("OK");
		StringBuilder tb = new StringBuilder(t);
		System.out.println(t.hashCode() + "  " + tb.hashCode());
	}

	private static void stringHashCode() {
		/**
		 * String类使用下列算法计算散列码：
		 * int hash = 0;
		 * for(int i=0;i<length();i++)
		 *     hash = 31 * hash + charAt(i);
		 * 所以，下面三个String变量，任何时候的散列码都是相同的
		 */
		String hello = "Hello";
		String harry = "Harry";
		String hacker = "Hacker";
		System.out.println(hello.hashCode() + " " + harry.hashCode() + " "
				+ hacker.hashCode());
	}
}
