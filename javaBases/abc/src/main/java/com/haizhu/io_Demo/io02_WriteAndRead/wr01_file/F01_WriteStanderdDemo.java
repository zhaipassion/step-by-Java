package com.haizhu.io_Demo.io02_WriteAndRead.wr01_file;

import java.io.FileWriter;
import java.io.IOException;

public class F01_WriteStanderdDemo {
	public static void main(String[] args) {
		FileWriter fw = null;
		try {
			// use this args will not overwrite the exists file --> new FileWriter("Test.txt",true)
			fw = new FileWriter(System.getProperty("user.dir")
					+ "/src/javaThings/io_Demo/io02_WriteAndRead/wr01_file/ReadAndWriteTestFile.txt");
			fw.write("Hello ");
			fw.append("world! ");
			fw.flush();
			fw.append("\r\nI'm haizhu!");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				// before close, should check the fw whether exists or not
				if (fw != null) {
					fw.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}