package com.haizhu.io_Demo.io07_ObjectStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class OS02_ObjectReaderDemo {
	public static void main(String[] args) {
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(
					new FileInputStream(
							System.getProperty("user.dir")
									+ "/src/javaThings/io_Demo/io07_ObjectStream/Person.object"));
			try {
				/**
				 * Change the No's value,to prove it is not serialized.
				 */
				Person No1 = new Person("John",25,60.0);
				Person No2 = new Person("Alex",26,60.0);
				Person No3 = new Person("Smith",27,60.0);
				System.out.println(No1.toString());
				System.out.println(No2.toString());
				System.out.println(No3.toString());
				System.out.println("-------------------------------分割线-------------------------------");
				/**
				 * We know the obj's class is Person,so we can use directly.
				 */
				Person per = (Person)ois.readObject();
				System.out.println(per.toString());
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
