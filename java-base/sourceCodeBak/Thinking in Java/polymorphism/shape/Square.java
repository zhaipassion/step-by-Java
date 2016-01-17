package com.books.book03.polymorphism.shape;//: polymorphism/shape/Square.java

import static com.books.book03.net.mindview.util.Print.print;

public class Square extends Shape {
    public void draw() {
        print("Square.draw()");
    }

    public void erase() {
        print("Square.erase()");
    }
} ///:~
