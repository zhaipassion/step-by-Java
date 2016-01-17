//: holding/IterableClass.java
// Anything Iterable works with foreach.

import java.util.Iterator;

public class IterableClass implements Iterable<String> {
    protected String[] words = ("And that is how " +
            "we know the Earth to be banana-shaped.").split(" ");

    public static void main(String[] args) {
        for (String s : new IterableClass())
            System.out.print(s + " ");
    }

    public Iterator<String> iterator() {
        return new Iterator<String>() {
            private int index = 0;

            public boolean hasNext() {
                return index < words.length;
            }

            public String next() {
                return words[index++];
            }

            public void remove() { // Not implemented
                throw new UnsupportedOperationException();
            }
        };
    }
} /* Output:
And that is how we know the Earth to be banana-shaped.
*///:~
