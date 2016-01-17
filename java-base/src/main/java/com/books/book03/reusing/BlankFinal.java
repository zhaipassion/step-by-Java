package com.books.book03.reusing;
//: reusing/BlankFinal.java
// "Blank" final fields.

/**
 * 空白final是指声明为final但又未给定初始值的域。
 * 无论什么情况，编译器都确保空白final在使用前必须被初始化。
 * （必须在域的定义处或者每个构造器中用表达式对final进行赋值）
 */
class Poppet {
    private int i;

    Poppet(int ii) {
        i = ii;
    }
}

public class BlankFinal {
    private final int i = 0; // Initialized final
    private final int j; // Blank final
    private final Poppet p; // Blank final reference

    // Blank finals MUST be initialized in the constructor:
    public BlankFinal() {
        j = 1; // Initialize blank final
        p = new Poppet(1); // Initialize blank final reference
    }

    public BlankFinal(int x) {
        j = x; // Initialize blank final
        p = new Poppet(x); // Initialize blank final reference
    }

    public static void main(String[] args) {
        new BlankFinal();
        new BlankFinal(47);
    }
}

///:~
