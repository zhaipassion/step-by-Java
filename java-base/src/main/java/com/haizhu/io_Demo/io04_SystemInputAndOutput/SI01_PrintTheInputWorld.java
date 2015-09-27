package com.haizhu.io_Demo.io04_SystemInputAndOutput;

import java.io.IOException;
import java.io.InputStream;

public class SI01_PrintTheInputWorld {
	public static void main(String[] args) {
		InputStream ins = System.in;
		int num = 0;
		try {
			while((num=ins.read())!=-1){
				System.out.println((char)num);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
