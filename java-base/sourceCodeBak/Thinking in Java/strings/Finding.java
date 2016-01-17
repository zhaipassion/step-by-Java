package com.books.book03.strings;
//: strings/Finding.java

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.books.book03.net.mindview.util.Print.print;
import static com.books.book03.net.mindview.util.Print.printnb;

public class Finding {
    public static void main(String[] args) {
        Matcher m = Pattern.compile("\\w+")
                .matcher("Evening is full of the linnet's wings");
        while (m.find())
            printnb(m.group() + " ");
        print();
        int i = 0;
        while (m.find(i)) {
            printnb(m.group() + " ");
            i++;
        }
    }
} /* Output:
Evening is full of the linnet s wings
Evening vening ening ning ing ng g is is s full full ull ll l of of f the the he e linnet linnet innet nnet net et t s s wings wings ings ngs gs s
*///:~
