package com.haizhu.io_Demo.io07_ObjectStream;

import java.io.Serializable;

public class Person implements Serializable {
	/**
	 * 序列号：是为了当你person类改变之后，还能够读取以前持久化的保存到文件的对象，这就实现了向下兼容。
	 * 比如：刚开始的时候，person类只有name属性，你持久化保存到person.txt文件，当你后来在person
	 * 类中又增加了一个age属性，如果没有序列号就会报错，如果有自己定义的序列号就可以正常读取。
	 */
	private static final long serialVersionUID = -6146692423805535979L;
	
	/**
	 * 静态不能被序列化
	 */
	private static Integer No = 0;
	private String name;
	private Integer age;
	/**
	 * transient 修饰之后不能被序列化
	 */
	private transient Double weight;
	Person(String name,Integer age,Double weight){
		this.name = name;
		this.age = age;
		this.weight = weight;
		No++;
	}
	public String toString(){
		return "No.:"+No+"\nname:"+this.name + "\nage:"+ this.age+"\nweight:"+weight;
	}
}
