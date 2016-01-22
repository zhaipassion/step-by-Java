package com.bob.java8.LambdaExpressions.demo02.bob;

/**
 * Created by Bob on 2016/1/23.
 */
public class Service {
  public int operate(int a, int b, MathOperation mathOperation) {
    return mathOperation.operation(a, b);
  }
}
