package com.books.book03.reusing;//: reusing/Hide.java
// Overloading a base-class method name in a derived
// class does not hide the base-class versions.

import static com.books.book03.net.mindview.util.Print.print;

/**
 * 覆写和重载：
 * 在基类和导出类有相同的方法名的时候：
 * 1. 如果参数类型相同，那么就是覆写，加上override注解，防止出错
 * 2. 如果参数类型不同，那么就是重载，返回值类型也就可以不一样了。
 *
 */
class Homer {
    char doh(char c) {
        print("doh(char)");
        return 'd';
    }

    float doh(float f) {
        print("doh(float)");
        return 1.0f;
    }
}

class Milhouse {
}

class Bart extends Homer {
    void doh(Milhouse m) {
        print("doh(Milhouse)");
    }
}

public class Hide {
    public static void main(String[] args) {
        Bart b = new Bart();
        b.doh(1);
        b.doh('x');
        b.doh(1.0f);
        b.doh(new Milhouse());
    }
}

/* Output:
doh(float)
doh(char)
doh(float)
doh(Milhouse)
*///:~
