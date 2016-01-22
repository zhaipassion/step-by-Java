package com.bob.java8.LambdaExpressions.demo02.bob;

/**
 * Created by Bob on 2016/1/23.
 */
public class Tester {
  public static void main(String args[]) {
    Service tester = new Service();
    //with type declaration
    MathOperation addition = (int a, int b) -> a + b;
    //with out type declaration
    MathOperation subtraction = (a, b) -> a - b;
    //with return statement along with curly braces
    MathOperation multiplication = (int a, int b) -> {
      return a * b;
    };
    //without return statement and without curly braces
    MathOperation division = (int a, int b) -> a / b;
    // Bob: 这里是将接口实例和参数一起传到方法中，在方法中使用实例调用接口中的方法并使用参数
    System.out.println("10 + 5 = " + tester.operate(10, 5, addition));
    System.out.println("10 - 5 = " + tester.operate(10, 5, subtraction));
    System.out.println("10 x 5 = " + tester.operate(10, 5, multiplication));
    System.out.println("10 / 5 = " + tester.operate(10, 5, division));
    // Bob: 上面的方法和下面的调用相同
    System.out.println("Bob test : 10 + 5 = " + addition.operation(10, 5));
    System.out.println("Bob test : 10 - 5 = " + subtraction.operation(10, 5));
    System.out.println("Bob test : 10 x 5 = " + multiplication.operation(10, 5));
    System.out.println("Bob test : 10 / 5 = " + division.operation(10, 5));
    // Bob: 第一种方法是不是就是服务的注册功能的实现？可以根据传入的参数的不同，调用不同的方法实现。

    //with parenthesis
    GreetingService greetService1 = message -> System.out.println("Hello " + message);
    //without parenthesis
    GreetingService greetService2 = (message) -> System.out.println("Hello " + message);
    greetService1.sayMessage("Mahesh");
    greetService2.sayMessage("Suresh");
  }
}

