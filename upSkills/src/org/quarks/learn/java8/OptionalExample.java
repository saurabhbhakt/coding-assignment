package org.quarks.learn.java8;

import java.util.Optional;

public class OptionalExample {
    public static void main(String[] args) {
        String name = "Java";

        // Using Optional to prevent null checks
        Optional<String> optionalName = Optional.ofNullable(name);
        optionalName.ifPresent(System.out::println); // Output: Java
    }
}

