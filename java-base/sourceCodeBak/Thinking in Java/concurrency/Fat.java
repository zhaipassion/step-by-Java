package com.books.book03.concurrency;
//: concurrency/Fat.java
// Objects that are expensive to create.

public class Fat {
    private static int counter = 0;
    private final int id = counter++;
    private volatile double d; // Prevent optimization

    public Fat() {
        // Expensive, interruptible operation:
        for (int i = 1; i < 10000; i++) {
            d += (Math.PI + Math.E) / (double) i;
        }
    }

    public void operation() {
        System.out.println(this);
    }

    public String toString() {
        return "Fat id: " + id;
    }
} ///:~
