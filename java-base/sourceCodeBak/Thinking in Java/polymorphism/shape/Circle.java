package com.books.book03.polymorphism.shape;
//: polymorphism/shape/Circle.java

import static com.books.book03.net.mindview.util.Print.print;

public class Circle extends Shape {
    public void draw() {
        print("Circle.draw()");
    }

    public void erase() {
        print("Circle.erase()");
    }
} ///:~
