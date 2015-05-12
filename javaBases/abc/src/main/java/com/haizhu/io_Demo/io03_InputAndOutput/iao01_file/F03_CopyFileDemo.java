package com.haizhu.io_Demo.io03_InputAndOutput.iao01_file;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class F03_CopyFileDemo {
	public static void main(String[] args) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream(
					System.getProperty("user.dir")
							+ "/src/javaThings/io_Demo/io03_InputAndOutput/iao01_file/HelloKitty.jpg");
			fos = new FileOutputStream(
					System.getProperty("user.dir")
							+ "/src/javaThings/io_Demo/io03_InputAndOutput/iao01_file/HelloKitty_Copy.jpg");
			int len = 0;
			byte[] buf = new byte[1024];
			while((len = fis.read(buf))!=-1){
				fos.write(buf, 0, len);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
