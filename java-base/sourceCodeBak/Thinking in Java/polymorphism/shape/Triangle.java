package com.books.book03.polymorphism.shape;
//: polymorphism/shape/Triangle.java

import static com.books.book03.net.mindview.util.Print.print;

public class Triangle extends Shape {
    public void draw() {
        print("Triangle.draw()");
    }

    public void erase() {
        print("Triangle.erase()");
    }
} ///:~
