package org.quarks.learn.java11;

import java.util.List;

public class LocalVariableSyntaxLambda {
    public static void main(String[] args) {
        List<String> names = List.of("Alice", "Bob", "Charlie");

        // Using 'var' in lambda parameter
        names.forEach((var name) -> System.out.println(name));
    }
}

