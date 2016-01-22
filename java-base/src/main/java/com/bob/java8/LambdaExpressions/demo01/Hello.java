package com.bob.java8.LambdaExpressions.demo01;

import static java.lang.System.out;

public class Hello {

  Runnable r1 = () -> out.println(this);
  Runnable r2 = () -> out.println(toString());

  public String toString() {
    return "Hello, world!";
  }

  public static void main(String... args) {
    new Hello().r1.run(); //Hello, world!
    new Hello().r2.run(); //Hello, world!

    // Bob: 使用原始方式
    Runnable bob1 = new Runnable() {
      @Override
      public void run() {
        out.print(new Hello());
      }
    };
    bob1.run();//Hello, world!
  }
}
