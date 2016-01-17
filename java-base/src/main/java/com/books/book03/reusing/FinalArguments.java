package com.books.book03.reusing;
//: reusing/FinalArguments.java
// Using "final" with method arguments.

/**
 * 在参数列表中以声明的方式将参数指明为final，将无法在方法中更改参数引用所指向的对象。
 * （这一特性主要用来向匿名内部类传递数据）
 * 只有在想要明确禁止覆盖时，才应该将方法设置为final。
 */
class Gizmo {
    public void spin() {
    }
}

public class FinalArguments {
    public static void main(String[] args) {
        FinalArguments bf = new FinalArguments();
        bf.without(null);
        bf.with(null);
        bf.g(10);
    }

    void with(final Gizmo g) {
        //! g = new Gizmo(); // Illegal -- g is final
    }

    void without(Gizmo g) {
        g = new Gizmo(); // OK -- g not final
        g.spin();
    }

    // void f(final int i) { i++; } // Can't change
    // You can only read from a final primitive:
    int g(final int i) {
        return i + 1;
    }
}

///:~
