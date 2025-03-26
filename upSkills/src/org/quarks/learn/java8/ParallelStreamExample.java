package org.quarks.learn.java8;

import java.util.*;

public class ParallelStreamExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");

        // Using Parallel Stream to process the stream concurrently
        names.parallelStream()
                .forEach(name -> System.out.println(Thread.currentThread().getName() + " - " + name));
    }
}

