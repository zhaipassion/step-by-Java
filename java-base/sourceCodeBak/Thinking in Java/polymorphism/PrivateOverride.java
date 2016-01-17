package com.books.book03.polymorphism;
//: polymorphism/PrivateOverride.java
// Trying to override a private method.

import static com.books.book03.net.mindview.util.Print.print;

public class PrivateOverride {
    public static void main(String[] args) {
        PrivateOverride po = new Derived();
        po.f();
    }

    private void f() {
        print("private f()");
    }
}

class Derived extends PrivateOverride {
    public void f() {
        print("public f()");
    }
} /* Output:
private f()
*///:~
