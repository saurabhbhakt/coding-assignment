package org.quarks.learn.java17;

public class SwitchPatternMatching {
    public static void main(String[] args) {
        Object obj = "Hello";

        switch (obj) {
            case Integer i -> System.out.println("It's an Integer: " + i);
            case String s -> System.out.println("It's a String: " + s);
            default -> System.out.println("Unknown type");
        }
    }
}

