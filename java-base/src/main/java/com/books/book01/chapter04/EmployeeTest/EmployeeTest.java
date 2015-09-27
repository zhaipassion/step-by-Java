package com.books.book01.chapter04.EmployeeTest;

import java.util.*;

/**
 * This program tests the Employee class.
 *
 * @author Cay Horstmann
 * @version 1.11 2004-02-19
 * @chapter 4.3.1 一个Employee类
 */
public class EmployeeTest {
    public static void main(String[] args) {
        // fill the staff array with three Employee objects
        Employee[] staff = new Employee[3];

        staff[0] = new Employee("Carl Cracker", 75000, 1987, 12, 15);
        staff[1] = new Employee("Harry Hacker", 50000, 1989, 10, 1);
        staff[2] = new Employee("Tony Tester", 40000, 1990, 3, 15);

        // raise everyone's salary by 5%
        for (Employee e : staff)
            e.raiseSalary(5);

        // print out information about all Employee objects
        for (Employee e : staff)
            System.out.println("name=" + e.getName() + ",salary="
                    + e.getSalary() + ",hireDay=" + e.getHireDay());
    }
}

/**
 * @author Bob
 * @ClassName: Employee
 * @Description: 在这个示例程序中包含两个类：一个Employee类；一个带有public访问修饰符的EmployeeTest类。
 * EmployeeTest类包含了 main方法，其中使用了前面介绍的指令。HZ：Employee类只能添加final修饰符，
 * public : The public type Employee must be defined in its own file
 * private : Illegal modifier for the class Employee; only public,
 * abstract & final are permitted
 * @date 2015年2月15日 上午9:31:33
 */
class Employee {
    public Employee(String n, double s, int year, int month, int day) {
        name = n;
        salary = s;
        GregorianCalendar calendar = new GregorianCalendar(year, month - 1, day);
        // GregorianCalendar uses 0 for January
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
