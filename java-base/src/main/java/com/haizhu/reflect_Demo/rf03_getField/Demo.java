package com.haizhu.reflect_Demo.rf03_getField;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class Demo {
	public static void main(String[] args) {
		String classPath = "com.haizhu.reflect_Demo.Student";
		try {
			getPublicField(classPath);
			System.out.println("\n-----------------------\n");
			getAllField(classPath);
			System.out.println("\n-----------------------\n");
			getPointField(classPath);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/** 取得 public 类型的属性 */
	public static void getPublicField(String classPath) throws Exception{
		Class<?> clazz = Class.forName(classPath);
		Field[] fs = clazz.getFields();
		for(Field f : fs){
			/** 取得修饰符 */
			int i = f.getModifiers();
			String modifier = Modifier.toString(i);
			/** type:属性类型 */
			Class<?> type = f.getType();
			/** getName()：类型的全称
			 *  getSimpleName()：类型的简称 */
			System.out.println(modifier + "\t" + type.getSimpleName() + "(" +type.getName() + ") \t" + f.getName());
		}
	}
	/** 取得所有类型的属性 */
	public static void getAllField(String classPath) throws Exception{
		Class<?> clazz = Class.forName(classPath);
		Field[] fs = clazz.getDeclaredFields();
		for(Field f : fs){
			int mod = f.getModifiers();
			String modStr = Modifier.toString(mod);
			Class<?> type = f.getType();
			System.out.println(modStr + "\t" + type.getSimpleName() + "("+ type.getName() + ")\t" + f.getName());
		}
	}

	/** 取得指定属性 */
	public static void getPointField(String classPath) throws Exception{
		Class<?> clazz = Class.forName(classPath);
		Object obj = clazz.newInstance();
		Field nameField = clazz.getDeclaredField("protectedStr");
		/** 赋予访问权限 */
		nameField.setAccessible(true);
		System.out.println(nameField.get(obj));
		nameField.set(obj, "newValue");
		System.out.println(nameField.get(obj));
	}
	
}
