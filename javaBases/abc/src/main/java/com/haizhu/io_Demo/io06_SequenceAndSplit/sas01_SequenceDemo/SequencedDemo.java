package com.haizhu.io_Demo.io06_SequenceAndSplit.sas01_SequenceDemo;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.io.FileInputStream;
import java.util.Enumeration;
import java.util.Vector;

public class SequencedDemo {
	public static void main(String[] args) {
		sequenceMethod();
	}

	public static void sequenceMethod(){
		String filePath = System.getProperty("user.dir")
				+ "/src/javaThings/io_Demo/io06_SequenceInputStream/";
		SequenceInputStream sis = null;
		FileOutputStream result = null;
		try {
			FileInputStream fis1 = new FileInputStream(filePath+"strem01.txt");
			FileInputStream fis2 = new FileInputStream(filePath+"strem02.txt");
			FileInputStream fis3 = new FileInputStream(filePath+"strem03.txt");
			result = new FileOutputStream(filePath+"result.txt");
			
			Vector<FileInputStream> vt = new Vector<FileInputStream>();
			vt.add(fis1);
			vt.add(fis2);
			vt.add(fis3);
			
			Enumeration<FileInputStream> em = vt.elements();
			
			sis = new SequenceInputStream(em);
			
			int len = 0;
			byte[] buf = new byte[1024];
			while((len=sis.read(buf))!=-1){
				result.write(buf, 0, len);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				sis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				result.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
