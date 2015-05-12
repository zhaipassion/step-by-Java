package com.haizhu.io_Demo.io02_WriteAndRead.wr02_buffer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BufferCopyFileDemo {
	public static void main(String[] args) {
		FileReader fr = null;
		FileWriter fw = null;
		BufferedReader bufReader = null;
		BufferedWriter bufWriter = null;
		try {
			fr = new FileReader(
					System.getProperty("user.dir")
					+ "/src/javaThings/io_Demo/io02_WriteAndRead/wr02_buffer/ReadAndWriteBufferedTestFile.txt");
			fw = new FileWriter(
					System.getProperty("user.dir")
					+ "/src/javaThings/io_Demo/io02_WriteAndRead/wr02_buffer/ReadAndWriteBufferedTestFile_Copy.txt");
			bufReader = new BufferedReader(fr);
			bufWriter = new BufferedWriter(fw);
			String line = null;
			while((line = bufReader.readLine())!=null){
                bufWriter.write(line);  
                //newLine()方法写入与操作系统相依的换行字符，依执行环境当时的OS来决定该输出那种换行字符
                bufWriter.newLine();  
                /**
                 * remember the flush() method
                 */
                bufWriter.flush();
            }  
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				/**
				 * this closed,the "fw" needn't to close any more.
				 */
				if(bufWriter!=null){
					bufWriter.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if(bufReader!=null){
					bufReader.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
