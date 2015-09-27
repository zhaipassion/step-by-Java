package com.books.question.StaticDemo;

/**
 * @author Bob
 * @ClassName: People
 * @Description: 会不会出现em1和em2取到同一个值的情况？
 * @date 2015年4月21日 下午9:52:01
 */

public class People {
    public static void main(String[] args) {
        Employee em1 = new Employee();
        Employee em2 = new Employee();

        em1.setId("em1");
        em2.setId("em2");

        System.out.println("em1:" + em1.getId() + ",em2:" + em2.getId());
    }
}

class Employee {
    private int id;
    private static int nextId = 1;

    public long getId() {
        return this.id;
    }

    public void setId(String name) {
        System.out.println(name + "开始赋值");
        this.id = nextId;
        nextId++;
        System.out.println(name + "赋值结束");
    }

}