package org.quarks.learn.java8;

import java.util.*;

public class MethodReferenceExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

        // Using Method Reference instead of Lambda
        names.forEach(System.out::println);  // Output: Alice, Bob, Charlie
    }
}

