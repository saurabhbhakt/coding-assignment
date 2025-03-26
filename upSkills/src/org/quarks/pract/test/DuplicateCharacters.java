package org.quarks.pract.test;



import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DuplicateCharacters {
    public static void main(String[] args) {
        String str = "programming";

        // Using groupingBy and filter to find duplicates
        usingGroupingByAndFilter(str);

        usingSetTrackDuplicates(str);
    }

    private static void usingSetTrackDuplicates(String str) {
        System.out.println("usingGroupingByAndFilter");
        Set<Character> seen = new HashSet<>();
        Set<Character> duplicates = new HashSet<>();

        str.chars()
                .mapToObj(c -> (char) c)
                .forEach(c -> {
                    if (!seen.add(c)) {  // If add returns false, the character is a duplicate
                        duplicates.add(c);
                    }
                });

        duplicates.forEach(System.out::println);
    }

    private static void usingGroupingByAndFilter(String str) {
        System.out.println("usingGroupingByAndFilter");
        Map<Character, Long> charCountMap = str.chars()
                .mapToObj(c -> (char) c)  // Convert int to char
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        // Filter characters that appear more than once
        charCountMap.entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .forEach(System.out::println); // Output: r, g
    }
}

