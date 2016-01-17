package com.books.book03.generics;

//: generics/GenericWriting.java

import java.util.ArrayList;
import java.util.List;

public class GenericWriting {
    static List<Apple> apples = new ArrayList<Apple>();
    static List<Fruit> fruit = new ArrayList<Fruit>();

    static <T> void writeExact(List<T> list, T item) {
        list.add(item);
    }

    static void f1() {
        writeExact(apples, new Apple());
        // writeExact(fruit, new Apple()); // Error:
        // Incompatible types: found Fruit, required Apple
    }

    static <T> void writeWithWildcard(List<? super T> list, T item) {
        list.add(item);
    }

    static void f2() {
        writeWithWildcard(apples, new Apple());
//        writeWithWildcard(fruit, new Apple());
    }

    public static void main(String[] args) {
        f1();
        f2();
    }

    private static class Apple {
    }

    private static class Fruit {
    }
}

///:~
