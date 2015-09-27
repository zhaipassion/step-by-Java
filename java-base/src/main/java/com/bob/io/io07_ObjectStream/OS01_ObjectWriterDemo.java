package com.bob.io.io07_ObjectStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class OS01_ObjectWriterDemo {
    public static void main(String[] args) {
        objectWrite();
    }

    private static void objectWrite() {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(
                    new FileOutputStream(
                            System.getProperty("user.dir")
                                    + "/src/javaThings/io_Demo/io07_ObjectStream/Person.object"));
            /**
             * Get a person object with a name "Tom" and age 24.The value of static property "No" is 0.
             */
            Person p = new Person("Tom", 24, 60.0);
            /**
             * Stored a person object whit detailed information.
             */
            oos.writeObject(p);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
