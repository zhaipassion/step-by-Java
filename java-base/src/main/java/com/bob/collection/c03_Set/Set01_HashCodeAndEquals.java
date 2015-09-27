package com.bob.collection.c03_Set;

import java.util.HashSet;
import java.util.Iterator;

public class Set01_HashCodeAndEquals {
	public static void main(String[] args) {
		HashSet<Person> set = new HashSet<Person>();
		set.add(new Person("Tom",24));
		set.add(new Person("John",24));
		set.add(new Person("Tom",24));
		/**
		 * Test result:
		 */
		System.out.println("set lenght:"+set.size()+"\n");
		Iterator<Person> iter = set.iterator();
		while(iter.hasNext()){
			// 因为使用了泛型，所以不用强制转换
			Person p = iter.next();
			System.out.println(p.getName()+":"+p.getAge());
		}
	}
}

class Person {
	private String name;
	private Integer age;

	Person(String name, Integer age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public int hashCode() {
		return this.name.hashCode() + this.age;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Person)) {
			return false;
		}
		Person p = (Person) obj;
		return this.name.equals(p.name) && this.age.equals(p.age);
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