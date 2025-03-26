package org.quarks.learn.java8;

import java.util.*;

public class LambdaExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        // Using a Lambda Expression to iterate over a List
        names.forEach(name -> System.out.println(name));
    }
}

