package com.bob.reflect.rf_undoClass;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
/**
 * @ClassName: Demo 
 * @Description: 反编译demo
 * @author ZhuHongbo 
 * @date 2014年1月7日 下午11:49:14
 */
public class Demo {
	public static void main(String[] args) {
		String classPath = "Student";
		String stringPath = "Student";
		try {
			System.out.println(undoClass(classPath));
			System.out.println("------------------------------------");
			System.out.println(undoClass(stringPath));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static StringBuilder undoClass(String classPath) throws Exception {
		StringBuilder sb = new StringBuilder();
		/** 取得 class */
		Class<?> clazz = Class.forName(classPath);
		/** class 信息 */
		Package packageName = clazz.getPackage();
		String clazzMod = Modifier.toString(clazz.getModifiers());
		String clazzSimpleName = clazz.getSimpleName();
		/** 拼装输出语句 */
		sb.append(packageName + "\n");
		sb.append(clazzMod + " class " + clazzSimpleName+" {\n");
		/** 取得 fields */
		Field[] fd = clazz.getDeclaredFields();
		for (Field f : fd) {
			/** field 信息 */
			int mod = f.getModifiers();
			Class<?> type = f.getType();
			/** 拼装属性信息 */
			sb.append("\t" + Modifier.toString(mod) + "\t" + type.getSimpleName() + "\t" + f.getName() + ";\n");
		}
		sb.append("}");
		return sb;
	}
}
