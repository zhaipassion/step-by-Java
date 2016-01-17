package com.books.book03.generics;
//: generics/ExplicitTypeSpecification.java

import com.books.book03.net.mindview.util.New;
import com.books.book03.typeinfo.pets.Person;
import com.books.book03.typeinfo.pets.Pet;

import java.util.List;
import java.util.Map;

public class ExplicitTypeSpecification {
    static void f(Map<Person, List<Pet>> petPeople) {
    }

    public static void main(String[] args) {
        f(New.<Person, List<Pet>>map());
    }
} ///:~
