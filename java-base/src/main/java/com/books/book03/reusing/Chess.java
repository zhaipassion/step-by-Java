package com.books.book03.reusing;
//: reusing/Chess.java
// Inheritance, constructors and arguments.


import static com.books.book03.net.mindview.util.Print.print;

/**
 * 带有参数的构造器调用
 *
 * Bob：
 * this() 表示对当前类的构造器的调用
 * super() 表示对基类的构造器的调用
 */
class Game {
    Game(int i) {
        print("Game constructor");
    }
}

class BoardGame extends Game {
    BoardGame(int i) {
        super(i);
        print("BoardGame constructor");
    }
}

public class Chess extends BoardGame {
    Chess() {
        super(11);
        print("Chess constructor");
    }

    public static void main(String[] args) {
        Chess x = new Chess();
    }
}

/* Output:
Game constructor
BoardGame constructor
Chess constructor
*///:~
