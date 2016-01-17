package com.books.book03.generics;
//: generics/SimplerPets.java
//import com.books.book03.typeinfo.pets.*

import com.books.book03.net.mindview.util.New;
import com.books.book03.typeinfo.pets.Person;
import com.books.book03.typeinfo.pets.Pet;

import java.util.List;
import java.util.Map;

public class SimplerPets {
    public static void main(String[] args) {
        Map<Person, List<? extends Pet>> petPeople = New.map();
        // Rest of the code is the same...
    }
} ///:~
