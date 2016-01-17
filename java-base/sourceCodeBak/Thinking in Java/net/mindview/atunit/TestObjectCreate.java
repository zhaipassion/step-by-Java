package com.books.book03.net.mindview.atunit;
//: net/mindview/atunit/TestObjectCreate.java
// The @Unit @TestObjectCreate tag.

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface TestObjectCreate {
} ///:~
