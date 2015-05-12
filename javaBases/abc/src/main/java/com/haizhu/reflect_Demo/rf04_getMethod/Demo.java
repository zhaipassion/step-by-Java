package com.haizhu.reflect_Demo.rf04_getMethod;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Demo {
	public static void main(String[] args) {
		String classPath = "com.haizhu.reflect_Demo.Student";
		String stringPath = "java.lang.String";
		try {
			getAllMethod(classPath);
			System.out.println("-----------------------------");
			getAllMethod(stringPath);
			System.out.println("-----------------------------");
			getPointMethod(classPath);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/** 所有方法 */
	public static void getAllMethod(String classPath) throws Exception{
		Class<?> clazz = Class.forName(classPath);
		Method[] method = clazz.getDeclaredMethods();
		for(Method m : method){
			/** 修饰符 */
			int mod = m.getModifiers();
			String methodMod = Modifier.toString(mod);
			/** 返回值类型 */
			Class<?> returnType = m.getReturnType();
			/** 参数列表 */
			Class<?>[] parameterTypes = m.getParameterTypes();
			StringBuilder ptsb = new StringBuilder();
			for(Class<?> parameterType : parameterTypes){
				ptsb.append(parameterType.getSimpleName() + " ");
			}
			System.out.println(methodMod + " " + returnType.getSimpleName() + " " + m.getName() + "(" + ptsb +")");
		}
	}
	/** 获取特定方法 
	 * 至少需要两个参数：方法名＆参数类型（可以多个）*/
	public static void getPointMethod(String classPath) throws Exception{
		Class<?> clazz = Class.forName(classPath);
		Object obj = clazz.newInstance();
		/** 取得方法 */
		Method m1 = clazz.getDeclaredMethod("simpleMethod");
		Method m2 = clazz.getDeclaredMethod("simpleMethod", String.class);
		/**执行方法，调用对象是obj，参数为空或者是“Tom”（多个参数的话，用逗号隔开往后接着写） */
		m1.invoke(obj);
		m2.invoke(obj, "Tom");
	}
}
