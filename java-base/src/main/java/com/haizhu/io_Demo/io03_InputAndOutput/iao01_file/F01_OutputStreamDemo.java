package com.haizhu.io_Demo.io03_InputAndOutput.iao01_file;

import java.io.FileOutputStream;
import java.io.IOException;

public class F01_OutputStreamDemo {
	public static void main(String[] args) {
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(System.getProperty("user.dir")
					+ "/src/javaThings/io_Demo/io03_InputAndOutput/iao01_file/InputAndOutputTestFile.txt");
			fos.write("Hello, inputStream and outputStream!".getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
