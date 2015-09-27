package com.bob.collection.c03_Set;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * 1、TreeSet排序的第一种方式，让元素自身具备比较性，元素需要实现comparable接口，
 * 覆盖compareTo()方法，这种方式也称为元素的自然排序，或者叫做默认排序。
 * 2、当元素自身不具备比较性时，或者具备的比较性不是所需要的，这时就需要让集合自身具备比 较性，在集合初始化时，就有了比较方式。
 * 两种方式都存在时，以第二种为主。
 *
 * @author Bob
 */
public class Set022_ComparableDemo {
    public static void main(String[] args) {
        TreeSet<Teacher> ts = new TreeSet<Teacher>(new MyCompare());
        ts.add(new Teacher("Tom", 24));
        ts.add(new Teacher("Tom", 25));
        ts.add(new Teacher("John", 24));
        ts.add(new Teacher("Smith", 25));
        /**
         * Test result:
         */
        Iterator<Teacher> iter = ts.iterator();
        while (iter.hasNext()) {
            Teacher t = iter.next();
            System.out.println(t.getName() + ":" + t.getAge());
        }
    }
}

/**
 * 将Teacher默认的按照age排序，改为按照name排序
 *
 * @author Bob
 */
class MyCompare implements Comparator<Object> {
    @Override
    public int compare(Object o1, Object o2) {
        Teacher t1 = (Teacher) o1;
        Teacher t2 = (Teacher) o2;
        int num = t1.getName().compareTo(t2.getName());
        if (num == 0) {
            return new Integer(t1.getAge()).compareTo(new Integer(t2.getAge()));
        }
        return num;
    }
}

class Teacher implements Comparable<Object> {
    private String name;
    private Integer age;

    Teacher(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Object obj) {
        if (!(obj instanceof Teacher)) {
            throw new RuntimeException("The args is not Teacher!");
        }
        Teacher s = (Teacher) obj;
        if (this.age > s.age) {
            return 1;
        }
        if (this.age == s.age) {
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