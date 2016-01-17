package com.books.book03.annotations;
//: annotations/AtUnitExternalTest.java
// Creating non-embedded tests.

import com.books.book03.net.mindview.atunit.Test;
import com.books.book03.net.mindview.util.OSExecute;

public class AtUnitExternalTest extends AtUnitExample1 {
    public static void main(String[] args) throws Exception {
        OSExecute.command(
                "java net.mindview.atunit.AtUnit AtUnitExternalTest");
    }

    @Test
    boolean _methodOne() {
        return methodOne().equals("This is methodOne");
    }

    @Test
    boolean _methodTwo() {
        return methodTwo() == 2;
    }
} /* Output:
annotations.AtUnitExternalTest
  . _methodOne
  . _methodTwo This is methodTwo

OK (2 tests)
*///:~
