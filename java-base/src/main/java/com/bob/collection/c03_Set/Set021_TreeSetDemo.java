package com.bob.collection.c03_Set;

import java.util.Iterator;
import java.util.TreeSet;

public class Set021_TreeSetDemo {
    public static void main(String[] args) {
        /**
         * 将自定义排序类传进来
         */
        TreeSet<Student> ts = new TreeSet<Student>();
        ts.add(new Student("Tom", 24));
        ts.add(new Student("John", 24));
        ts.add(new Student("Smith", 25));
        /**
         * Test result:
         */
        Iterator<Student> iter = ts.iterator();
        while (iter.hasNext()) {
            // 因为使用了泛型，所以不用强制转换
            Student t = iter.next();
            System.out.println(t.getName() + ":" + t.getAge());
        }
    }
}

class Student implements Comparable<Object> {
    private String name;
    private Integer age;

    Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Object obj) {
        if (!(obj instanceof Student)) {
            throw new RuntimeException("The args is not Student!");
        }
        Student s = (Student) obj;
        if (this.age > s.age) {
            return 1;
        }
        if (this.age == s.age) {
            // 当age相同时，继续判断name是否相同，name相同视为同一个对象，不同的话进行排序
            return this.name.compareTo(s.name);
        }
        return -1;
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