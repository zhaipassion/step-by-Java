package com.bob.java8.LambdaExpressions.demo03;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Bob on 2016/1/23.
 */
public class ListDemo {
  public static void main(String[] args) {
    String[] atp = {
        "Rafael Nadal", "Novak Djokovic",
        "Stanislas Wawrinka",
        "David Ferrer", "Roger Federer",
        "Andy Murray", "Tomas Berdych",
        "Juan Martin Del Potro"
    };
    List<String> players = Arrays.asList(atp);

    // 以前的循环方式
    System.out.println("\nforeach表达式:");
    for (String player : players) {
      System.out.println(player + "; ");
    }

    // 使用 lambda 表达式以及函数操作(functional operation)
    System.out.println("\n以下使用lambda表达式:");
    players.forEach((player) -> System.out.println(players + "; "));

    // 在 Java 8 中使用双冒号操作符(double colon operator)
    // 方法引用是使用两个冒号::这个操作符号。
    System.out.println("\n以下使用双冒号操作符:");
    players.forEach(System.out::println);
  }
}
