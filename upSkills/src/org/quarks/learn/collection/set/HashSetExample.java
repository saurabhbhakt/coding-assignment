package org.quarks.learn.collection.set;

import java.util.*;

public class HashSetExample {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("Apple");
        set.add("Banana");
        set.add("Apple"); // Duplicate, will not be added

        // Iterate over set
        for (String item : set) {
            System.out.println(item);
        }
    }
}

