//: io/DirectoryDemo.java
// Sample use of Directory utilities.

import com.books.book03.net.mindview.util.*;

import java.io.File;

import static com.books.book03.net.mindview.util.Print.print;

public class DirectoryDemo {
    public static void main(String[] args) {
        // All directories:
        PPrint.pprint(Directory.walk(".").dirs);
        // All files beginning with 'T'
        for (File file : Directory.local(".", "T.*"))
            print(file);
        print("----------------------");
        // All Java files beginning with 'T':
        for (File file : Directory.walk(".", "T.*\\.java"))
            print(file);
        print("======================");
        // Class files containing "Z" or "z":
        for (File file : Directory.walk(".", ".*[Zz].*\\.class"))
            print(file);
    }
} /* Output: (Sample)
[.\xfiles]
.\TestEOF.class
.\TestEOF.java
.\TransferTo.class
.\TransferTo.java
----------------------
.\TestEOF.java
.\TransferTo.java
.\xfiles\ThawAlien.java
======================
.\FreezeAlien.class
.\GZIPcompress.class
.\ZipCompress.class
*///:~
