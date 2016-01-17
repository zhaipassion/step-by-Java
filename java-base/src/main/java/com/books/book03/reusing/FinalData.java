package com.books.book03.reusing;
//: reusing/FinalData.java
// The effect of final on fields.

import java.util.Random;

import static com.books.book03.net.mindview.util.Print.print;

/**
 * 1.既是statis优势final的域，只占用一段不能改变的存储空间
 * 2.对于基本类型，final使数值无法改变；对于引用类型，final使引用地址无法改变，但是引用对象的属性值可以改变
 * 3.不能因为某数据是final的，就认为在编译时可以知道它的值，比如：i4
 */
class Value {
    int i; // Package access

    public Value(int i) {
        this.i = i;
    }
}

public class FinalData {
    // Typical public constant:
    public static final int VALUE_THREE = 39;
    private static final int VALUE_TWO = 99;
    private static final Value VAL_3 = new Value(33);
    private static Random rand = new Random(47);
    static final int INT_5 = rand.nextInt(20);
    // Can be compile-time constants:
    private final int valueOne = 9;
    // Cannot be compile-time constants:
    private final int i4 = rand.nextInt(20);
    private final Value v2 = new Value(22);
    // Arrays:
    private final int[] a = {1, 2, 3, 4, 5, 6};
    private String id;
    private Value v1 = new Value(11);
    public FinalData(String id) {
        this.id = id;
    }

    public static void main(String[] args) {
        FinalData fd1 = new FinalData("fd1");
        //! fd1.valueOne++; // Error: can't change value
        fd1.v2.i++; // Object isn't constant!
        fd1.v1 = new Value(9); // OK -- not final
        for (int i = 0; i < fd1.a.length; i++)
            fd1.a[i]++; // Object isn't constant!
        //! fd1.v2 = new Value(0); // Error: Can't
        //! fd1.VAL_3 = new Value(1); // change reference
        //! fd1.a = new int[3];
        print(fd1);
        print("Creating new FinalData");
        FinalData fd2 = new FinalData("fd2");
        print(fd1);
        print(fd2);
    }

    public String toString() {
        return id + ": " + "i4 = " + i4 + ", INT_5 = " + INT_5;
    }
}


/* Output:
fd1: i4 = 15, INT_5 = 18
Creating new FinalData
fd1: i4 = 15, INT_5 = 18
fd2: i4 = 13, INT_5 = 18
*///:~
