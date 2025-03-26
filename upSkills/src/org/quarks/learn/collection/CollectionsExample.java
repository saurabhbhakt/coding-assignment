package org.quarks.learn.collection;

import java.util.*;

public class CollectionsExample {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(1);
        list.add(2);

        // Sorting using Collections.sort()
        Collections.sort(list);

        System.out.println(list);  // Output: [1, 2, 3]
    }
}

