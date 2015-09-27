package com.haizhu.io_Demo.io06_SequenceAndSplit.sas02_SplitDemo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class SplitDemo {
	public static void main(String[] args) {
		splitMethod();
	}
	
	/**
	 * java 并没有提供和sequenceInputStream相对饮的spllit方法，可以自己实现：
	 * java didn't provide the opposite method of sequenceInputStream's,
	 * now, we write one below:
	 */
	private static void splitMethod(){
		String filePath = System.getProperty("user.dir")+"/src/javaThings/io_Demo/io06_SequenceAndSplit/sas02_SplitDemo/";
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream(filePath+"Tulips.jpg");
			int count = 1;
			int len = 0;
			/**
			 * 将这个图片切割为128k一个的文件
			 * Cut the picture to some files with 128k size.
			 */
			byte[] buf = new byte[1024*128];
			while((len=fis.read(buf))!=-1){
				fos = new FileOutputStream(filePath+"Tulips_"+count+".part");
				fos.write(buf, 0, len);
				fos.close();
				count++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
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
