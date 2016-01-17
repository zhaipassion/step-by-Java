package com.books.book03.reusing;
//: reusing/FinalOverridingIllusion.java
// It only looks like you can override
// a private or private final method.

import static com.books.book03.net.mindview.util.Print.print;

/**
 * 1.使用final的原因是想要确保在继承中使方法行为保持不变，并且不会被覆写。
 * 2.类中所有的private的方法都隐式的指定为final的。由于无法取用priavte方法，
 * 所以也就无法覆盖它。可以对private方法添加final修饰词，但这并不能给private方法增加任何额外的意义。
 * 3.这一问题会造成混淆，因为，如果你试图覆盖一个private方法（隐含是final的），似乎是奏效的，
 * 而且编译器也不会报错。（Bob：但这并不是覆盖，而是继承类中创建了一个同名方法而已，因为这里方法调用的
 * 地方，并没有涉及到向上转型，所以并不是覆盖了基类的方法。）
 */
class WithFinals {
    // Identical to "private" alone:
    private final void f() {
        print("WithFinals.f()");
    }

    // Also automatically "final":
    private void g() {
        print("WithFinals.g()");
    }
}

class OverridingPrivate extends WithFinals {
    private final void f() {
        print("OverridingPrivate.f()");
    }

    private void g() {
        print("OverridingPrivate.g()");
    }
}

class OverridingPrivate2 extends OverridingPrivate {
    public final void f() {
        print("OverridingPrivate2.f()");
    }

    public void g() {
        print("OverridingPrivate2.g()");
    }
}

public class FinalOverridingIllusion {
    public static void main(String[] args) {
        OverridingPrivate2 op2 = new OverridingPrivate2();
        op2.f();
        op2.g();
        // You can upcast:
        OverridingPrivate op = op2;
        // But you can't call the methods:
        //! op.f();
        //! op.g();
        // Same here:
        WithFinals wf = op2;
        //! wf.f();
        //! wf.g();
    }
}


/* Output:
OverridingPrivate2.f()
OverridingPrivate2.g()
*///:~
