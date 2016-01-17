package com.books.book03.access;
//: access/ChocolateChip2.java

import com.books.book03.access.cookie2.Cookie;

public class ChocolateChip2 extends Cookie {
    public ChocolateChip2() {
        System.out.println("ChocolateChip2 constructor");
    }

    public static void main(String[] args) {
        ChocolateChip2 x = new ChocolateChip2();
        x.chomp();
    }

    public void chomp() {
        bite();
    } // Protected method
} /* Output:
Cookie constructor
ChocolateChip2 constructor
bite
*///:~
