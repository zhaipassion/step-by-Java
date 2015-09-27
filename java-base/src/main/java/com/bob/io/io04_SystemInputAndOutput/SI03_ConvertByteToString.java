package com.bob.io.io04_SystemInputAndOutput;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class SI03_ConvertByteToString {
	/**
	 * 具体选择哪个流，通过下面两个方面进行确定：
	 * 1.明确源和目的
	 * 源：    输入流 InputStream & Reader
	 * 目的：输出流 OutputStream & Writer
	 * 2.操作的数据是否是纯文本
	 * 是：字符流
	 * 否：字节流
	 */
	public static void main(String[] args) {
		InputStream in = System.in;
		/**
		 * 将字节流对象转换成字符流对象，使用转换流：InputStreamReader
		 * Convert the InputStream data to InputStreamReader
		 */
		InputStreamReader isr = new InputStreamReader(in);
		/**
		 * 为了提高效率，使用字符串进行缓冲区技术高效操作，使用BufferedReader
		 * For improve the efficiency, use the BufferedReader class.
		 */
		BufferedReader br = new BufferedReader(isr);

		/**
		 * 小知识点，不重要：out默认是控制台，可以更改为文本文件：
		 * System.setOut(new PrintStream("setOut.txt"));
		 */
		OutputStream os = System.out;
		/**
		 * 输出到控制台：以前的输出到console也是字节，现在改成字符输出
		 */
		OutputStreamWriter osw = new OutputStreamWriter(os);
		BufferedWriter bf = new BufferedWriter(osw);
		
		/**
		 * 上面六句可以合成两句：
		 * BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 * BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		 * 也可以从文件读取信息打印到控制台：
		 * BufferedReader br = new BufferedReader(new InputStreamReader("in.txt"));
		 * 当然，也可以将输出的结果输出到file文件：
		 * BufferedWriter bw = new BufferedWriter(new OutputStreamWriter("out.txt"));
		 */
		
		/**
		 * 临时存储一行数据的区域
		 * line: to store the temporary data
		 */
		String line = null;
		try {
			while((line = br.readLine())!=null){
				if("over".equals(line)){
					break;
				}else{
					/**
					 * 最开始的字节流输出可以使用这个
					 * System.out.println(line.toUpperCase());
					 */
					osw.write(line.toUpperCase());
					// 换行
					bf.newLine();
					// 刷新缓冲区，不然控制台没有输出
					osw.flush();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			try {
				br.close();
				isr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
