package com.books.book03.typeinfo;
//: typeinfo/Person.java
// A class with a Null Object.

import com.books.book03.net.mindview.util.Null;

class Person {
    public static final Person NULL = new NullPerson();
    public final String first;
    public final String last;
    public final String address;

    // etc.
    public Person(String first, String last, String address) {
        this.first = first;
        this.last = last;
        this.address = address;
    }

    public String toString() {
        return "Person: " + first + " " + last + " " + address;
    }

    public static class NullPerson
            extends Person implements Null {
        private NullPerson() {
            super("None", "None", "None");
        }

        public String toString() {
            return "NullPerson";
        }
    }
} ///:~
