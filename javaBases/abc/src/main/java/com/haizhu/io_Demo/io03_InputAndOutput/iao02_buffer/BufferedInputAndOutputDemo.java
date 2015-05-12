package com.haizhu.io_Demo.io03_InputAndOutput.iao02_buffer;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedInputAndOutputDemo {
	public static void main(String[] args) {
		BufferedInputStream bufIps = null;
		BufferedOutputStream bufOps = null;
		try {
			bufIps = new BufferedInputStream(
					new FileInputStream(
							System.getProperty("user.dir")
									+ "/src/javaThings/io_Demo/io03_InputAndOutput/iao02_buffer/Breathless.mp3"));
			bufOps = new BufferedOutputStream(
					new FileOutputStream(
							System.getProperty("user.dir")
									+ "/src/javaThings/io_Demo/io03_InputAndOutput/iao02_buffer/Copy_Breathless.mp3"));
			int num = 0;
			/**
			 * use num? Yes.
			 */
			if ((num = bufIps.read()) != -1) {
				/**
				 * read one byte, write one. But, it's operated in the buffer,so it's quickly.
				 */
				bufOps.write(num);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bufIps.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				bufOps.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
