package com.bob.collection_Demo.c00_tips.t01_ListSort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class mianTest {
	public static void main(String[] args) {
		normal_method();
		System.out.println("=======================================");
		innerClass_method();
	}

	/**
	 * @Description: 使用匿名内部类
	 * @author ZHB
	 * @date 2014年6月24日 下午2:39:41 
	 * @return void
	 */
	private static void innerClass_method() {
		// 生成测试数据
		List<People> list = new ArrayList<People>();
		People p1 = new People(2, "Tom", 24);
		People p2 = new People(1, "Jhon", 26);
		People p3 = new People(3, "Akon", 24);
		list.add(p1);
		list.add(p2);
		list.add(p3);
		// 排序
		Collections.sort(list, new Comparator<People>() {
			@Override
			public int compare(People dr1, People dr2) {
				// 数值类型直接比较大小
				int flag = dr1.getAge() - dr2.getAge();
				if (flag == 0) {
					// 字符串比较，使用compare方法
					flag = dr1.getName().compareTo(dr2.getName());
					// 也可用这种方法，忽略大小写
					flag = dr1.getName().compareToIgnoreCase(dr2.getName());
				}
				return flag;
			}
		});
		// 验证
		for (People p : list) {
			System.out.println(p.getId() + "\t" + p.getAge() + "\t" + p.getName());
		}
	}

	/**
	 * @Description: 一般方法
	 * @author ZHB
	 * @date 2014年6月24日 下午2:37:55
	 * @return void
	 */
	private static void normal_method() {
		// 生成测试数据
		List<People> list = new ArrayList<People>();
		People p1 = new People(2, "Tom", 24);
		People p2 = new People(1, "Jhon", 26);
		People p3 = new People(3, "Akon", 24);
		list.add(p1);
		list.add(p2);
		list.add(p3);
		// 排序
		Collections.sort(list, new PeopleSortComparator());
		// 验证
		for (People p : list) {
			System.out.println(p.getId() + "\t" + p.getAge() + "\t" + p.getName());
		}
	}
}
