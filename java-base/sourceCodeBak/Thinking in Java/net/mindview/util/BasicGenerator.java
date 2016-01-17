package com.books.book03.net.mindview.util;
//: net/mindview/util/BasicGenerator.java
// Automatically create a Generator, given a class
// with a default (no-arg) constructor.

public class BasicGenerator<T> implements Generator<T> {
    private Class<T> type;

    public BasicGenerator(Class<T> type) {
        this.type = type;
    }

    // Produce a Default generator given a type token:
    public static <T> Generator<T> create(Class<T> type) {
        return new BasicGenerator<T>(type);
    }

    public T next() {
        try {
            // Assumes type is a public class:
            return type.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
} ///:~
