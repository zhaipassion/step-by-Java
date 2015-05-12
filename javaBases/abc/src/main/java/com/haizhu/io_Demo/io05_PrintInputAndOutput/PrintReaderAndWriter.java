package com.haizhu.io_Demo.io05_PrintInputAndOutput;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class PrintReaderAndWriter {
	
	/**
	 * PrintWriter
	 * 构造函数可以接受的参数：
	 * 1，file对象：file
	 * 2，字符串路径：filePath
	 * 3，字节输出流：OutputStream
	 * 4，字符输出了：Writer
	 */
	public static void main(String[] args) {
		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
		/**
		 * PrintWriter(目的，boolean)，这个布尔值表示是否自动刷新。
		 * 这个目的可以是控制台也可以是file路径或者file文件，但是当是file
		 * 的时候，这个boolean值即使为true在程序结束前也不能自动刷新了。
		 * 为了自动刷新可以将这个路径file文件封装在FileWriter流中：
		 */
		//PrintWriter pr = new PrintWriter(System.out,true);
		PrintWriter pr = null;
		String line = null;
		try {
			pr = new PrintWriter(new FileWriter(System.getProperty("user.dir")
					+ "/src/javaThings/io_Demo/io05_PrintInputAndOutput/PrintDemo.txt"),true);
			while((line=bufr.readLine())!=null){
				if(line.equals("over")){
					break;
				}else{
					//pr.write(line.toUpperCase());
					//pr.flush();
					pr.println(line.toUpperCase());
					pr.flush();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bufr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			pr.close();
		}
	}
}
