package com.bob.constructor;

class Person {
	private String name;
	private Integer age;

	/**
	 * constructor code block: 
	 * this code block execute before the constructor method.
	 * 
	 */
	{
		System.out.println("person code block run...");
		/**
		 *  all the person constructor has the cry() method,
		 *  so, the cry() method could place here, because
		 *  this code will execute whichever the constructor
		 *  be used.
		 */
		this.cry();
	}
	
	/**
	 * default constructor
	 */
	Person() {
		System.out.println("constructor Person() over");
	}

	/**
	 * overwrite constructor: get a name when just be created,and execute the cry() once
	 * @param name
	 */
	Person(String name) {
		this.name = name;
		this.cry();
		System.out.println("constructor Person(name) over");
	}

	/**
	 * overwrite constructor
	 * 
	 * @param name
	 * @param age
	 */
	Person(String name, Integer age) {
		/**
		 * call the Person(String name) constructor, must be placed in the first line
		 */
		this(name);
		this.age = age;
		System.out.println("constructor Person(name,age) over");
	}

	public void cry() {
		System.out.println("baby crying....");
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

}

/**
 * Every object,before sued,should be initialized, so,there should be a
 * constructor. And,there is a default constructor,if you don not overwrite
 * it,it will be execute automatically.
 * 
 * When you should overwrite the constructor? It's the time when you want to add
 * more attributes or methods when the new object is create.For example, if you
 * want to get a new person with attribute name and method cry(),you can use the
 * second constructor instead of the default one.
 * 
 * Tips: 
 * 1. The constructor only execute once when the object is create. But the normal
 * method such as cry() can execute any times you want.
 * 
 */
public class ConstructorDemo {
	public static void main(String[] args) {
		Person p1 = new Person();
		Person p2 = new Person("Tom");
		Person p3 = new Person("Tom",24);
		System.out.println(p1.getName());
		System.out.println(p2.getName());
		System.out.println(p3.getName()+"-->"+p3.getAge());
	}
}
