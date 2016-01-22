package com.bob.java8.LambdaExpressions.demo01;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Nio {

    public static void main(String...args) throws IOException {
    
    
        System.out.println("\n----->first 5 java file names:");
        Files.list(Paths.get("."))
            .map(Path::getFileName) // still a path
            .map(Path::toString) // convert to Strings
            .filter(name -> name.endsWith(".java"))
            .sorted() // sort them alphabetically
            .limit(5) // first 5
            .forEach(System.out::println);
        /*
        System.out.println("\n----->Print the code:");
        
        Files.lines(Paths.get("Nio.java"))
            .map(String::trim)
            .filter(s -> !s.isEmpty())
            .forEach(System.out::println);
        /*-/
        System.out.println("\n----->Average line length:");
        System.out.println(
            Files.lines(Paths.get("Nio.java"))
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .collect(averagingInt(String::length))
                );
        IntSummaryStatistics stats = Files.lines(Paths.get("Nio.java"))
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .collect(summarizingInt(String::length));

        System.out.println(stats.getAverage());
        System.out.println("count=" + stats.getCount());
        System.out.println("max=" + stats.getMax());
        System.out.println("min=" + stats.getMin());
        */
        /*String str = Stream.of("hello", "java", "8")
            .collect(joining("-"));
        System.out.println(str);*/
     }
}
