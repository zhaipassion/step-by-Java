package com.books.book03.annotations;
//: annotations/Testable.java

import com.books.book03.net.mindview.atunit.Test;

public class Testable {
    public void execute() {
        System.out.println("Executing..");
    }

    @Test
    void testExecute() {
        execute();
    }
} ///:~
