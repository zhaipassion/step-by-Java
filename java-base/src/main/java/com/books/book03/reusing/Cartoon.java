package com.books.book03.reusing;
//: reusing/Cartoon.java
// Constructor calls during inheritance.

import static com.books.book03.net.mindview.util.Print.print;

/**
 * 构建构成是从基类“向外”扩散的，所以基类在导出类构造器可以访问它之前
 * 就已经完成了初始化。即便部位基类创建构造器，编译器也会为你合成一个
 * 默认的构造器，该构造器将调用基类的构造器。
 * <p>
 * Bob:
 * 有一种情况不会创建默认的构造器，那就是有且仅有带有参数的构造器，却
 * 没有手动声明不带参数的构造器，这样编译器就不会自动合成默认构造器了。
 */
class Art {
    Art() {
        print("Art constructor");
    }
}

class Drawing extends Art {
    Drawing() {
        print("Drawing constructor");
    }
}

public class Cartoon extends Drawing {
    public Cartoon() {
        print("Cartoon constructor");
    }

    public static void main(String[] args) {
        Cartoon x = new Cartoon();
    }
}

/* Output:
Art constructor
Drawing constructor
Cartoon constructor
*///:~
