package com.books.book01.chapter05.toStringTest;

import java.util.Arrays;

/**
 * @author Bob
 * @ClassName: ToStringTest
 * @Description: toString方法测试，一般对象两种调用方法，数组只有一种方法
 * @date 2015年2月19日 下午3:35:31
 */
public class ToStringTest {
    public static void main(String[] args) {

        // 一般对象的toString方法
        People p = new People("HZ", 27);
        System.out.println("使用\"\"+p的方法调用toString：");
        System.out.println("" + p);
        System.out.println("使用p.toString的方法调用toString：");
        System.out.println(p.toString());

        System.out.println("\n\n");
        // 一维数组的toString方法
        int[] luckyNumbers = {2, 3, 5, 7, 11, 13};
        System.out.println("使用\"\"+luckyNumbers的方法调用toString：");
        System.out.println("" + luckyNumbers);
        System.out.println("使用Arrays.toString的方法调用toString：");
        System.out.println(Arrays.toString(luckyNumbers));

        System.out.println("\n\n");
        // 二维数组的toString方法
        int i = 5;
        int j = 3;
        int val = 0;
        String[][] xLine = new String[i][];
        for (int m = 0; m < i; m++) {
            String[] yLine = new String[j];
            xLine[m] = yLine;
            for (int n = 0; n < j; n++) {
                yLine[n] = val + "";
                val++;
            }
        }
        System.out.println("使用Arrays.toString的方法调用toString：");
        System.out.println(Arrays.deepToString(xLine));
    }
}

class People {
    private String name;
    private int age;

    public People(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "name: " + this.name + ", age: " + this.age;
    }
}