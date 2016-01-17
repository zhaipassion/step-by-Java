package com.books.book03.typeinfo;
//: typeinfo/AnonymousImplementation.java
// Anonymous inner classes can't hide from reflection.

import com.books.book03.typeinfo.interfacea.A;

import static com.books.book03.net.mindview.util.Print.print;

class AnonymousA {
    public static A makeA() {
        return new A() {
            public void f() {
                print("public C.f()");
            }

            public void g() {
                print("public C.g()");
            }

            void u() {
                print("package C.u()");
            }

            protected void v() {
                print("protected C.v()");
            }

            private void w() {
                print("private C.w()");
            }
        };
    }
}

public class AnonymousImplementation {
    public static void main(String[] args) throws Exception {
        A a = AnonymousA.makeA();
        a.f();
        System.out.println(a.getClass().getName());
        // Reflection still gets into the anonymous class:
        HiddenImplementation.callHiddenMethod(a, "g");
        HiddenImplementation.callHiddenMethod(a, "u");
        HiddenImplementation.callHiddenMethod(a, "v");
        HiddenImplementation.callHiddenMethod(a, "w");
    }
} /* Output:
public C.f()
AnonymousA$1
public C.g()
package C.u()
protected C.v()
private C.w()
*///:~
