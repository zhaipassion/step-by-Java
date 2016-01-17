package com.books.book03.concurrency;
//: concurrency/Philosopher.java
// A dining philosopher

import java.util.Random;
import java.util.concurrent.TimeUnit;

import static com.books.book03.net.mindview.util.Print.print;

public class Philosopher implements Runnable {
    private final int id;
    private final int ponderFactor;
    private Chopstick left;
    private Chopstick right;
    private Random rand = new Random(47);

    public Philosopher(Chopstick left, Chopstick right,
                       int ident, int ponder) {
        this.left = left;
        this.right = right;
        id = ident;
        ponderFactor = ponder;
    }

    private void pause() throws InterruptedException {
        if (ponderFactor == 0) return;
        TimeUnit.MILLISECONDS.sleep(
                rand.nextInt(ponderFactor * 250));
    }

    public void run() {
        try {
            while (!Thread.interrupted()) {
                print(this + " " + "thinking");
                pause();
                // Philosopher becomes hungry
                print(this + " " + "grabbing right");
                right.take();
                print(this + " " + "grabbing left");
                left.take();
                print(this + " " + "eating");
                pause();
                right.drop();
                left.drop();
            }
        } catch (InterruptedException e) {
            print(this + " " + "exiting via interrupt");
        }
    }

    public String toString() {
        return "Philosopher " + id;
    }
} ///:~
