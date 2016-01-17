package com.books.book03.strings;

//: strings/SplitDemo.java

import java.util.Arrays;
import java.util.regex.Pattern;

import static com.books.book03.net.mindview.util.Print.print;

public class SplitDemo {
    public static void main(String[] args) {
        String input =
                "This!!unusual use!!of exclamation!!points";
        print(Arrays.toString(
                Pattern.compile("!!").split(input)));
        // Only do the first three:
        print(Arrays.toString(
                Pattern.compile("!!").split(input, 3)));
    }
} /* Output:
[This, unusual use, of exclamation, points]
[This, unusual use, of exclamation!!points]
*///:~
