package com.books.book03.reusing;
//: reusing/Orc.java
// The protected keyword.

import static com.books.book03.net.mindview.util.Print.print;

/**
 * 尽管可以创建protected域，但是最好的方式还是将域保持为private，
 * 你应当一直保留“更改底层实现的权利”。然后通过protected方法来控制
 * 类的继承者的访问权限。
 * Bob：
 * 1. protected是导出类可以访问的权限
 * 2. 但是一般来说域是私有的，方法是public的，而不是protected
 */
class Villain {
    private String name;

    public Villain(String name) {
        this.name = name;
    }

    protected void set(String nm) {
        name = nm;
    }

    public String toString() {
        return "I'm a Villain and my name is " + name;
    }
}

public class Orc extends Villain {
    private int orcNumber;

    public Orc(String name, int orcNumber) {
        super(name);
        this.orcNumber = orcNumber;
    }

    public static void main(String[] args) {
        Orc orc = new Orc("Limburger", 12);
        print(orc);
        orc.change("Bob", 19);
        print(orc);
    }

    public void change(String name, int orcNumber) {
        set(name); // Available because it's protected
        this.orcNumber = orcNumber;
    }

    public String toString() {
        return "Orc " + orcNumber + ": " + super.toString();
    }
}

/* Output:
Orc 12: I'm a Villain and my name is Limburger
Orc 19: I'm a Villain and my name is Bob
*///:~
