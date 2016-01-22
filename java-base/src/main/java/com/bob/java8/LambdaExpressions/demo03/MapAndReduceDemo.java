package com.bob.java8.LambdaExpressions.demo03;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Bob on 2016/1/23.
 */
public class MapAndReduceDemo {
  public static void main(String[] args) {
    // applying 12% VAT on each purchase
    // Without lambda expressions:
    System.out.println();
    List<Integer> costBeforeTax1 = Arrays.asList(100, 200, 300, 400, 500);
    for (Integer cost : costBeforeTax1) {
      double price = cost + .12 * cost;
      System.out.println(price);
    }

    // With Lambda expression:
    System.out.println();
    List<Integer> costBeforeTax2 = Arrays.asList(100, 200, 300, 400, 500);
    costBeforeTax2.stream().map((cost) -> cost + .12 * cost)
        .forEach(System.out::println);


    // Applying 12% VAT on each purchase
    // Old way:
    System.out.println();
    List<Integer> costBeforeTax3 = Arrays.asList(100, 200, 300, 400, 500);
    double total = 0;
    for (Integer cost : costBeforeTax3) {
      double price = cost + .12 * cost;
      total = total + price;

    }
    System.out.println("Total : " + total);

    // New way:
    System.out.println();
    List<Integer> costBeforeTax4 = Arrays.asList(100, 200, 300, 400, 500);
    double bill = costBeforeTax4.stream().map((cost) -> cost + .12 * cost)
        .reduce((sum, cost) -> sum + cost)
        .get();
    System.out.println("Total : " + bill);


    // Convert String to Uppercase and join them using coma
    System.out.println();
    List<String> G7 = Arrays.asList("USA", "Japan", "France", "Germany",
        "Italy", "U.K.", "Canada");
    String G7Countries = G7.stream().map(x -> x.toUpperCase())
        .collect(Collectors.joining(", "));
    System.out.println(G7Countries);


    // Create List of square of all distinct numbers
    System.out.println();
    List<Integer> numbers = Arrays.asList(9, 10, 3, 4, 7, 3, 4);
    List<Integer> distinct = numbers.stream().map(i -> i * i).distinct()
        .collect(Collectors.toList());
    System.out.printf("Original List : %s,  Square Without duplicates : %s %n", numbers, distinct);


    //Get count, min, max, sum, and average for numbers
    List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
    IntSummaryStatistics stats = primes.stream().mapToInt((x) -> x)
        .summaryStatistics();
    System.out.println("Highest prime number in List : " + stats.getMax());
    System.out.println("Lowest prime number in List : " + stats.getMin());
    System.out.println("Sum of all prime numbers : " + stats.getSum());
    System.out.println("Average of all prime numbers : " + stats.getAverage());

  }
}
