package org.quarks.learn.java11;

import java.util.List;

public class VarInLambda {
    public static void main(String[] args) {
        List<String> names = List.of("Alice", "Bob", "Charlie");

        // Using 'var' in lambda expression
        names.forEach((var name) -> System.out.println(name));
    }
}

