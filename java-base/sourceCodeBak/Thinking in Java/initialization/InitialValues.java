package com.books.book03.initialization;
//: initialization/InitialValues.java
// Shows default initial values.

import static com.books.book03.net.mindview.util.Print.print;

public class InitialValues {
    boolean t;
    char c;
    byte b;
    short s;
    int i;
    long l;
    float f;
    double d;
    InitialValues reference;

    public static void main(String[] args) {
        InitialValues iv = new InitialValues();
        iv.printInitialValues();
    /* You could also say:
    new InitialValues().printInitialValues();
    */
    }

    void printInitialValues() {
        print("Data type      Initial value");
        print("boolean        " + t);
        print("char           [" + c + "]");
        print("byte           " + b);
        print("short          " + s);
        print("int            " + i);
        print("long           " + l);
        print("float          " + f);
        print("double         " + d);
        print("reference      " + reference);
    }
} /* Output:
Data type      Initial value
boolean        false
char           [ ]
byte           0
short          0
int            0
long           0
float          0.0
double         0.0
reference      null
*///:~
