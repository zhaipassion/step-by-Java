package com.bob.io.io02_WriteAndRead.wr01_file;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class F03_CopyFileDemo {
	public static void main(String[] args) {
		FileReader fr = null;
		FileWriter fw = null;
		try {
			fr = new FileReader(
					System.getProperty("user.dir")
					+ "/src/javaThings/io_Demo/io02_WriteAndRead/wr01_file/ReadAndWriteTestFile.txt");
			fw = new FileWriter(
					System.getProperty("user.dir")
					+ "/src/javaThings/io_Demo/io02_WriteAndRead/wr01_file/ReadAndWriteTestFile_Copy.txt");
			char[] buf = new char[1024];
			int len = 0;
			while ((len = fr.read(buf)) != -1) {
				fw.write(buf, 0, len);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(fr!=null){
				try {
					fr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(fw!=null){
				try {
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
