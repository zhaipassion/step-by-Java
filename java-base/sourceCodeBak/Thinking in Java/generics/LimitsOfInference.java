package com.books.book03.generics;
//: generics/LimitsOfInference.java

import com.books.book03.typeinfo.pets.Person;
import com.books.book03.typeinfo.pets.Pet;

import java.util.List;
import java.util.Map;

public class LimitsOfInference {
    static void
    f(Map<Person, List<? extends Pet>> petPeople) {
    }

    public static void main(String[] args) {
        // f(New.map()); // Does not compile
    }
} ///:~
