package com.bob.java8.LambdaExpressions.demo01;

import static java.lang.System.out;

public class Hello {

    // Bob
    Runnable t1 = new RunnableTest();

    Runnable r1 = () -> out.println(this);
    Runnable r2 = () -> out.println(toString());

    public String toString() {
        return "Hello, world!";
    }

    public static void main(String... args) {
        new Hello().r1.run(); //Hello, world!
        new Hello().r2.run(); //Hello, world!

        // Bob: 使用原始方式
        new Hello().t1.run();//Hello, world!
    }
}

/**
 * Bob
 */
class RunnableTest implements Runnable {
    @Override
    public void run() {
        out.print(new Hello());
    }
}

