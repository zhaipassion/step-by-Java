package com.bob.collection.c05_Iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

/**
 * @author ZHB
 * @ClassName: Ite01_normal
 * @Description: <link>http://examples.javacodegeeks.com/core-java/util/java-iterator-and-listiterator-example/</link>
 * @date 2014年6月23日 上午10:49:37
 */
public class Ite01_normal {
    public static void main(String args[]) {

        ArrayList<String> list = new ArrayList<String>();

        list.add("One");
        list.add("Two");
        list.add("Three");
        list.add("Four");
        list.add("Five");

        System.out.println("Iterator using while loop: ");
        Iterator<String> it1 = list.iterator();
        while (it1.hasNext()) {
            System.out.println("Next element: " + it1.next());
        }

        System.out.println("Iterator using for loop: ");
        for (Iterator<String> it2 = list.iterator(); it2.hasNext(); ) {
            System.out.println("Next element: " + it2.next());
        }

        System.out.println("List iterator (forward iteration): ");
        ListIterator<String> lit = list.listIterator();
        while (lit.hasNext()) {
            System.out.println("Next element: " + lit.next());

        }

        System.out.println("List iterator (backward iteration): ");
        lit = list.listIterator(list.size());
        while (lit.hasPrevious()) {
            System.out.println("Previous element: " + lit.previous());

        }

        lit.next();
        lit.add("One more element");
        System.out.println("Modified list after the insertion of the new element");

        System.out.println("Index of next element: " + lit.nextIndex());
        System.out.println("Index of previous element: " + lit.previousIndex());

        for (lit = list.listIterator(); lit.hasNext(); ) {
            System.out.println("Next element: " + lit.next());
        }

        lit.previous();
        lit.remove();

        System.out.println("Modified list after the removal of an element");
        for (lit = list.listIterator(); lit.hasNext(); ) {
            System.out.println("Next element: " + lit.next());
        }

    }
}