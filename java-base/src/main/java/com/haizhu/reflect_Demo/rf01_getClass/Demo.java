package com.haizhu.reflect_Demo.rf01_getClass;

import com.haizhu.reflect_Demo.Student;

/**
 * @ClassName: Demo
 * @Description: 获取class的三种方法
 * @author ZhuHongbo
 * @date 2014年1月6日 下午11:46:02
 */
public class Demo {
	@SuppressWarnings({ "rawtypes" })
	public static void main(String[] args) throws Exception {
		/**
		 * c1引用保存内存地址指向堆中的对象，该对象代表的是Student整个类
		 * 另外：这个会执行静态语句块，下面两个不会
		 */
		Class c1 = Class.forName("com.haizhu.reflect_Demo.Student");// 将Student类加载到JVM
		/**
		 * java中每个类型（包括基本类型和引用类型）都有class属性
		 */
		Class c2 = Student.class;
		/**
		 * java语言中任何一个对象都有getClass()方法
		 */
		Student stu = new Student();
		Class c3 = stu.getClass();
		
		/**
		 * 打印结果为true，说明取得的这三个class是同一个，内存地址相同，指向堆中唯一的一个对象
		 */
		System.out.println(c1==c2);
		System.out.println(c2==c3);
	}
}
