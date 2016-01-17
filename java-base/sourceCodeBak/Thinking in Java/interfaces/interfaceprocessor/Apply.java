//: interfaces/interfaceprocessor/Apply.java
package interfaces.interfaceprocessor;

import static com.books.book03.net.mindview.util.Print.print;

public class Apply {
    public static void process(Processor p, Object s) {
        print("Using Processor " + p.name());
        print(p.process(s));
    }
} ///:~
