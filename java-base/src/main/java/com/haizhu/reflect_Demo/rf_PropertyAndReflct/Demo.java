package com.haizhu.reflect_Demo.rf_PropertyAndReflct;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Date;
import java.util.Properties;

public class Demo {
	public static void main(String[] args) {
		String filePath = System.getProperty("user.dir")
				+ "/src/javaThings/reflect_Demo/rf03_PropertyAndReflct/classInfo.properties";
		try {
			getInstanceByProperty(filePath);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void getInstanceByProperty(String filePath) throws Exception{
		Properties ppt = new Properties();
		ppt.load(new BufferedReader(new FileReader(filePath)));
		String className = ppt.getProperty("className");
		Object obj = Class.forName(className).newInstance();
		if(obj instanceof Date){
			Date date = (Date)obj;
			System.out.println(date);
		}
	}
}
