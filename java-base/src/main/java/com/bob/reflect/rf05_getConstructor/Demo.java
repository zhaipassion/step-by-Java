package com.bob.reflect.rf05_getConstructor;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

/**
 * @ClassName: Demo 
 * @Description: 获取构造方法并创建对象 
 * @author ZhuHongbo 
 * @date 2014年1月8日 下午8:10:10
 */
public class Demo {
	public static void main(String[] args) {
		String className = "Student";
		try {
			getAllConstructor(className);
			System.out.println("-----------------------------");
			getPointConstructor(className);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/** 取得所有构造方法 */
	public static void getAllConstructor(String classPath) throws Exception{
		StringBuilder sb = new StringBuilder();
		/**  */
		Class<?> clazz = Class.forName(classPath);
		/**  */
		Constructor<?>[] cons = clazz.getConstructors();
		for(Constructor<?> con : cons){
			/**  */
			String conMod = Modifier.toString(con.getModifiers());
			sb.append(conMod+" ");
			/**  */
			//String conName = con.getName();
			String conName = clazz.getSimpleName();
			sb.append(conName+" (");
			/**  */
			Class<?>[] parameterTypes = con.getParameterTypes();
			for(Class<?> p : parameterTypes){
				String pName = p.getSimpleName();
				sb.append(pName+" ");
			}
			sb.append("){\n}\n");
			System.out.println(sb);
		}
	}
	/** 取得特定构造方法 */
	public static void getPointConstructor(String className) throws Exception{
		Class<?> clazz = Class.forName(className);
		Constructor<?> con = clazz.getDeclaredConstructor(String.class);
		/** 使用构造方法创建对象 */
		Object obj = con.newInstance("Tom");
		System.out.println(obj);
	}
}
