package com.bob.java8.LambdaExpressions.demo01;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FilesTest {
    public static void main(String[] args) throws IOException {

        String userDir = System.getProperty("user.dir");
        userDir = userDir.contains("java-base") ? userDir : userDir + "\\java-base";
        String pathDir = "\\src\\main\\java\\com\\bob\\java8\\LambdaExpressions";
        Path path = Paths.get(userDir + pathDir + "\\Nio.java");

        try (Stream st = Files.lines(path)) {
            st.forEach(System.out::println);
        }
    }

}

