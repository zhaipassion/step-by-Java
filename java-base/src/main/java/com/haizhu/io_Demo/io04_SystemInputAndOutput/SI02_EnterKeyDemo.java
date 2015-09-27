package com.haizhu.io_Demo.io04_SystemInputAndOutput;

import java.io.IOException;
import java.io.InputStream;

/**
 * 这个也是一次读取一行的 BuffereInputStream 的 readLine 方法的原理，这是引出下个范例。
 * This is the principle of the method "readLine()" in class BufferedInputStream.
 * @author Haizhu
 */
public class SI02_EnterKeyDemo {
	public static void main(String[] args) {
		InputStream ins = System.in;
		StringBuilder sb = new StringBuilder();
		int num = 0;
		try {
			while(true){
				num = ins.read();
				/**
				 * 一个Enter键包含一个“\r”，一个“\n”
				 */
				if(num=='\r'){
					continue;
				}else if(num=='\n'){
					String s = sb.toString();
					if("over".equals(s)){
						break;
					}else{
						System.out.println(s.toUpperCase());
						sb.delete(0, sb.length());
					}
				}else{
					sb.append((char)num);
				}
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
