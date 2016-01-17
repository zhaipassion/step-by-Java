package com.books.book03.reusing;
//: reusing/Jurassic.java
// Making an entire class final.

class SmallBrain {
}

final class Dinosaur {
    int i = 7;
    int j = 1;
    SmallBrain x = new SmallBrain();

    void f() {
    }
}

//! class Further extends Dinosaur {}
// error: Cannot extend final class 'Dinosaur'

public class Jurassic {
    public static void main(String[] args) {
        Dinosaur n = new Dinosaur();
        n.f();
        n.i = 40;
        n.j++;
        // Bob: 虽然类是final的，但是域的值是可以修改的
        System.out.println(n.i);
        System.out.println(n.j);
    }
}

///:~
