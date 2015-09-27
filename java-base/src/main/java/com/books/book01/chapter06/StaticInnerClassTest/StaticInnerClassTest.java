package com.books.book01.chapter06.StaticInnerClassTest;

/**
 * 【6.4.7】【静态内部类】This program demonstrates the use of static inner classes.
 * 
 * @version 1.01 2004-02-27
 * @author Cay Horstmann
 */
public class StaticInnerClassTest {
	public static void main(String[] args) {
		double[] d = new double[20];
		for (int i = 0; i < d.length; i++)
			d[i] = 100 * Math.random();
		ArrayAlg.Pair p = ArrayAlg.minmax(d);
		System.out.println("min = " + p.getFirst());
		System.out.println("max = " + p.getSecond());
	}
}

class ArrayAlg {
	// 静态内部类：作为返回值的封装类，这样一次可以返回多个值
	public static class Pair {
		private double first;
		private double second;

		public Pair(double f, double s) {
			first = f;
			second = s;
		}

		public double getFirst() {
			return first;
		}

		public double getSecond() {
			return second;
		}
	}

	public static Pair minmax(double[] values) {
		double min = Double.MAX_VALUE;
		double max = Double.MIN_VALUE;
		for (double v : values) {
			if (min > v)
				min = v;
			if (max < v)
				max = v;
		}
		return new Pair(min, max);
	}
}

/**有时候，使用内部类只是为了把一个类隐藏在另外一个类的内部，并不需要内部类引用外围类对象。
 * 为此，可以 将内部类声明为static，以便取消产生的引用。
 * 
 */
