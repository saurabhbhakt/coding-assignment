package org.quarks.learn.collection.list;

import java.util.*;

public class ArrayListExample {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");

        // Iterate over list
        for (String item : list) {
            System.out.println(item);
        }

        // Access element by index
        System.out.println("First element: " + list.get(0));
    }
}

