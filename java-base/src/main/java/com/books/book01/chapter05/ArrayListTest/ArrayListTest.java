package com.books.book01.chapter05.ArrayListTest;

import java.util.*;

/**
 * This program demonstrates the ArrayList class.
 * 
 * @version 1.1 2004-02-21
 * @author Cay Horstmann
 */
public class ArrayListTest {
	public static void main(String[] args) {
		// fill the staff array list with three Employee objects
		ArrayList<Employee> staff = new ArrayList<Employee>();

		staff.add(new Employee("Carl Cracker", 75000, 1987, 12, 15));
		staff.add(new Employee("Harry Hacker", 50000, 1989, 10, 1));
		staff.add(new Employee("Tony Tester", 40000, 1990, 3, 15));

		// raise everyone's salary by 5%
		for (Employee e : staff)
			e.raiseSalary(5);

		// print out information about all Employee objects
		for (Employee e : staff)
			System.out.println("name=" + e.getName() + ",salary="
					+ e.getSalary() + ",hireDay=" + e.getHireDay());

		// 数组列表转数组：toArray方法
		int len = staff.size();
		Employee[] eArray = new Employee[len];
		staff.toArray(eArray);
		// 数组转数组列表
		len = eArray.length;
		List<Employee> list = new ArrayList<Employee>(len);
		for (Employee e : eArray) {
			list.add(e);
		}
	}
}

class Employee {
	public Employee(String n, double s, int year, int month, int day) {
		name = n;
		salary = s;
		GregorianCalendar calendar = new GregorianCalendar(year, month - 1, day);
		hireDay = calendar.getTime();
	}

	public String getName() {
		return name;
	}

	public double getSalary() {
		return salary;
	}

	public Date getHireDay() {
		return hireDay;
	}

	public void raiseSalary(double byPercent) {
		double raise = salary * byPercent / 100;
		salary += raise;
	}

	private String name;
	private double salary;
	private Date hireDay;
}
