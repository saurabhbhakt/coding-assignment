package org.quarks.learn.collection.set;

import java.util.TreeSet;

public class TreeSetExample {
    public static void main(String[] args) {
        TreeSet<String> set = new TreeSet<>();
        set.add("Apple");
        set.add("Banana");
        set.add("Cherry");
        set.add("Apple");  // Duplicate, won't be added

        System.out.println(set);  // The elements will be in sorted order
    }
}

