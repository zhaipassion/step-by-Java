package com.books.book03.reusing;
//: reusing/Detergent.java
// Inheritance syntax & properties.

import static com.books.book03.net.mindview.util.Print.print;

/**
 * 复用类：继承
 */
class Cleanser {
    private String s = "Cleanser";

    /**
     * 即使一个类只有包访问权限，public main() 仍然是可以访问的。
     * 也就是说，Cleanser的 main() 函数可以直接运行，即便此类不是public类
     */
    public static void main(String[] args) {
        Cleanser x = new Cleanser();
        x.dilute();
        x.apply();
        x.scrub();
        print(x);
    }

    public void append(String a) {
        s += a;
    }

    public void dilute() {
        append(" dilute()");
    }

    public void apply() {
        append(" apply()");
    }

    public void scrub() {
        append(" scrub()");
    }

    public String toString() {
        return s;
    }
}

public class Detergent extends Cleanser {
    // Test the new class:
    public static void main(String[] args) {
        Detergent x = new Detergent();
        x.dilute();
        x.apply();
        x.scrub();
        x.foam();
        print(x);
        print("Testing base class:");
        Cleanser.main(args);
    }

    // Change a method:
    public void scrub() {
        append(" Detergent.scrub()");
        super.scrub(); // Call base-class version
    }

    // Add methods to the interface:
    public void foam() {
        append(" foam()");
    }
}

/* Output:
Cleanser dilute() apply() Detergent.scrub() scrub() foam()
Testing base class:
Cleanser dilute() apply() scrub()
*///:~
