package org.quarks.learn.java8;

import java.util.*;
import java.util.stream.*;

public class CollectorExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");

        // Collecting elements into a Set
        Set<String> nameSet = names.stream().collect(Collectors.toSet());
        System.out.println(nameSet);  // Output: [Alice, Bob, Charlie, David]

        // Concatenating strings using joining
        String result = names.stream().collect(Collectors.joining(", "));
        System.out.println(result);  // Output: Alice, Bob, Charlie, David
    }
}

