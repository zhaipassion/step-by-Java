package com.books.book03.reusing;
//: reusing/Beetle.java
// The full process of initialization.

import static com.books.book03.net.mindview.util.Print.print;

/**
 * 在对导出类进行加载的过程中，编译器注意到它有一个基类，于是它继续进行加载。
 * 不管你是否打算产生一个该基类的对象，这都要发生。
 * 所有的累加载完成后，对象就可以被创建了。首先，对象中所有的基本类型都会被
 * 设置为默认值，对象引用被设为null——这是将对象内存设置为二进制零值而一举产生。
 */
class Insect {
    private static int x1 = printInit("static Insect.x1 initialized");
    protected int j;
    private int i = 9;

    Insect() {
        print("i = " + i + ", j = " + j);
        j = 39;
    }

    static int printInit(String s) {
        print(s);
        return 47;
    }
}

public class Beetle extends Insect {
    private static int x2 = printInit("static Beetle.x2 initialized");
    private int k = printInit("Beetle.k initialized");

    public Beetle() {
        print("k = " + k);
        print("j = " + j);
    }

    public static void main(String[] args) {
        print("Beetle constructor");
        Beetle b = new Beetle();
    }
}

/* Output:
static Insect.x1 initialized
static Beetle.x2 initialized
Beetle constructor
i = 9, j = 0
Beetle.k initialized
k = 47
j = 39
*///:~
