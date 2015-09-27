package com.books.book01.chapter04.FactoryTest;

import java.text.NumberFormat;

/**
 * @ClassName: FactoryTest
 * @Description: NumberFormat类使用 factory方法产生不同风格的格式对象。
 * @chapter 4.4.4 Factory方法
 * @author HZ
 * @date 2015年2月15日 下午12:36:27
 */
public class FactoryTest {
	public static void main(String[] args) {
		// 当前国家的货币标识符
		NumberFormat currencyInstance = NumberFormat.getCurrencyInstance();
		// 百分比
		NumberFormat percentInstance = NumberFormat.getPercentInstance();
		double x = 0.1;
		System.out.println(currencyInstance.format(x));
		System.out.println(percentInstance.format(x));
	}
}
