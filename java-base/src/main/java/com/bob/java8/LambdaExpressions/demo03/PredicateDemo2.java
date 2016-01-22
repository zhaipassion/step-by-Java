package com.bob.java8.LambdaExpressions.demo03;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by Bob on 2016/1/23.
 */
public class PredicateDemo2 {
  public static void main(String[] args) {

    List names = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");

    // We can even combine Predicate using and(), or() And xor() logical functions
    // for example to find names, which starts with J and four letters long, you
    // can pass combination of two Predicate
    Predicate<String> startsWithJ = (n) -> n.startsWith("J");
    Predicate<String> fourLetterLong = (n) -> n.length() == 4;

    names.stream()
        .filter(startsWithJ.and(fourLetterLong))
        .forEach((n) -> System.out.print("\nName, which starts with 'J' and four letter long is:" + n));
  }
}
