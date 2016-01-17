package com.books.book03.annotations.database;
//: annotations/database/Uniqueness.java
// Sample of nested annotations

public @interface Uniqueness {
    Constraints constraints()
            default @Constraints(unique = true);
} ///:~
