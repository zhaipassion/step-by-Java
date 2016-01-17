package com.books.book03.reusing;
//: reusing/Wind.java
// Inheritance & upcasting.

/**
 * 继承和向上转型
 */
class Instrument {
    static void tune(Instrument i) {
        // ...
        i.play();
    }

    public void play() {
    }
}

// Wind objects are instruments
// because they have the same interface:
public class Wind extends Instrument {
    public static void main(String[] args) {
        Wind flute = new Wind();
        Instrument.tune(flute); // Upcasting
    }
} ///:~
