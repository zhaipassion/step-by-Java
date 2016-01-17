package com.books.book03.reusing;
//: reusing/SpaceShip.java

public class SpaceShip extends SpaceShipControls {
    private String name;

    public SpaceShip(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        SpaceShip protector = new SpaceShip("NSEA Protector");
        protector.forward(100);
    }

    public String toString() {
        return name;
    }
} ///:~
