package com.bob.io.io02_WriteAndRead.wr01_file;

import java.io.FileReader;
import java.io.IOException;

public class F02_ReadStanderdDemo {
    public static void main(String[] args) {
        readCharMethod();
        System.out.println("\n\n");
        readArrayMethod();
    }

    /**
     * once read a char,return the value
     */
    private static void readCharMethod() {
        FileReader fr = null;
        try {
            fr = new FileReader(
                    System.getProperty("user.dir")
                            + "/src/javaThings/io_Demo/io02_WriteAndRead/wr01_file/ReadAndWriteTestFile.txt");
            int ch = 0;
            while ((ch = fr.read()) != -1) {
                // here doesn't need to declare the encoding table,why?
                System.out.print((char) ch);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fr != null) {
                    fr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * once read a lot: read to the array ---> "char[] buf",return value number
     */
    private static void readArrayMethod() {
        FileReader fr = null;
        try {
            fr = new FileReader(
                    System.getProperty("user.dir")
                            + "/src/javaThings/io_Demo/io02_WriteAndRead/wr01_file/TestFile.txt");
            char[] buf = new char[1024];
            int num = 0;
            while ((num = fr.read(buf)) != -1) {
                System.out.print(new String(buf, 0, num));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fr != null) {
                    fr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
