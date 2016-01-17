package com.books.book03.generics;
//: generics/UseList.java
// {CompileTimeError} (Won't compile)

import java.util.List;

public class UseList<W, T> {
// Bob: 这里不注释掉就会报错
//    void f(List<T> v) {
//    }

    void f(List<W> v) {
    }
}

///:~
