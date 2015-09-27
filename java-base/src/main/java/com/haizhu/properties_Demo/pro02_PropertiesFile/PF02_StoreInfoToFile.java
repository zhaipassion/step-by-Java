package com.haizhu.properties_Demo.pro02_PropertiesFile;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class PF02_StoreInfoToFile {
	public static void main(String[] args) {
		String filePath = System.getProperty("user.dir")
				+ "/src/javaThings/properties_Demo/pro02_PropertiesFile/NumberAndName.properties";
		FileWriter fr = null;
		Properties ppt = new Properties();
		ppt.setProperty("No.4", "Smith");
		try {
			fr = new FileWriter(filePath,true);
			ppt.store(fr, "add No.4=Smith");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
