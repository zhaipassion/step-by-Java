package com.bob.java8.LambdaExpressions.demo03;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Bob on 2016/1/23.
 */
public class StringDemo {
  public static void main(String[] args) {
    List<String> strList = Arrays.asList("abc", "", "bcd", " ", "defg", "jk");

    // Create a List with String more than 2 characters
    List<String> filtered = strList.stream().filter(x -> x.length() > 2)
        .collect(Collectors.toList());
    System.out.printf("Original List : %s, filtered list : %s %n",
        strList, filtered);
  }
}
