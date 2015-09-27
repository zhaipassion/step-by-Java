package com.bob.reflect;

public class Student {
	{
		System.out.println("Student...");
	}
	private String name;
	private Integer age;
	/** 非私有属性 */
	public String publicStr;
	protected String protectedStr = "protectedStrValue";
	String defaultStr;
	
	public Student(){
		System.out.println("<<<<<无参构造>>>>>");
	}
	public Student(String name){
		System.out.println("<<<<<构造:name>>>>>");
		this.name = name;
	}
	public Student(String name,Integer age){
		System.out.println("<<<<<构造:name & age>>>>>");
		this.name = name;
		this.age = age;
	}

	public void simpleMethod(){
		System.out.println("===========  simpleMethod  ===========");
		System.out.println("NULL ARGS");
		System.out.println("===========  simpleMethod  ===========");
	}
	
	public void simpleMethod(String name){
		System.out.println("===========  simpleMethod  ===========");
		System.out.println(name);
		System.out.println("===========  simpleMethod  ===========");
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String toString(){
		return this.name + " --> " + this.age;
	}
}
