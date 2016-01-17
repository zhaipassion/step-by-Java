package com.books.book03.innerclasses;
//: innerclasses/BigEgg.java
// An inner class cannot be overriden like a method.

import static com.books.book03.net.mindview.util.Print.print;

class Egg {
    private Yolk y;

    public Egg() {
        print("New Egg()");
        y = new Yolk();
    }

    protected class Yolk {
        public Yolk() {
            print("Egg.Yolk()");
        }
    }
}

public class BigEgg extends Egg {
    public static void main(String[] args) {
        new BigEgg();
    }

    public class Yolk {
        public Yolk() {
            print("BigEgg.Yolk()");
        }
    }
} /* Output:
New Egg()
Egg.Yolk()
*///:~
