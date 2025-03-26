package org.quarks.learn.java8;

import java.util.*;
import java.util.stream.*;

public class StreamsExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");

        // Using Streams to filter and print names starting with 'A'
        names.stream()
                .filter(name -> name.startsWith("A"))
                .forEach(System.out::println);  // Output: Alice
    }
}

