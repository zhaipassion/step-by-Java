package com.haizhu.io_Demo.io03_InputAndOutput.iao01_file;

import java.io.FileInputStream;
import java.io.IOException;

public class F02_InputStreamDemo {
	public static void main(String[] args) {
		inputStreamMethod01();

		inputStreamMethod02();

		inputStreamMethod03();

	}

	/**
	 * When the file is not big, can use this method
	 */
	private static void inputStreamMethod03() {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(
					System.getProperty("user.dir")
							+ "/src/javaThings/io_Demo/io03_InputAndOutput/iao01_file/InputAndOutputTestFile.txt");
			System.out.println("\n\nThe result is:");

			int len = fis.available();
			byte[] buf = new byte[len];
			fis.read(buf);
			
			System.out.println(new String(buf, 0, len));
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * This method is the best way to operate the byte files.
	 */
	private static void inputStreamMethod02() {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(
					System.getProperty("user.dir")
							+ "/src/javaThings/io_Demo/io03_InputAndOutput/iao01_file/InputAndOutputTestFile.txt");
			System.out.println("\n\nThe result is:");
			byte[] buf = new byte[1024];
			int len = 0;
			while ((len = fis.read(buf)) != -1) {
				/**
				 * the new String(buf,0,len) method change the byte array to
				 * String
				 */
				System.out.print(new String(buf, 0, len));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Normally, don't use this method.
	 */
	private static void inputStreamMethod01() {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(
					System.getProperty("user.dir")
							+ "/src/javaThings/io_Demo/io03_InputAndOutput/iao01_file/InputAndOutputTestFile.txt");
			int num = 0;
			System.out.println("result:");
			while ((num = fis.read()) != -1) {
				System.out.print((char) num);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
