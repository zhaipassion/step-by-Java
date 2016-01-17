package com.books.book03.typeinfo.pets;
//: typeinfo/pets/Pets.java
// Facade to produce a default PetCreator.

import java.util.ArrayList;

public class Pets {
    public static final PetCreator creator =
            new LiteralPetCreator();

    public static Pet randomPet() {
        return creator.randomPet();
    }

    public static Pet[] createArray(int size) {
        return creator.createArray(size);
    }

    public static ArrayList<Pet> arrayList(int size) {
        return creator.arrayList(size);
    }
} ///:~
