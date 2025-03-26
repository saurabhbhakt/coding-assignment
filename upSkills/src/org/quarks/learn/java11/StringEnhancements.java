package org.quarks.learn.java11;

public class StringEnhancements {
    public static void main(String[] args) {
        String str = "  Hello, Java 11!  ";

        // Using isBlank() and strip()
        System.out.println(str.isBlank()); // Output: false
        System.out.println(str.strip());  // Output: "Hello, Java 11!"

        // Using repeat()
        String repeatedStr = "Java ".repeat(3);
        System.out.println(repeatedStr);  // Output: "Java Java Java "

        // Using lines()
        String multilineString = "Line 1\nLine 2\nLine 3";
        multilineString.lines().forEach(System.out::println);
    }
}

