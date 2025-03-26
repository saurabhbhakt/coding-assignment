package org.quarks.learn.collection.map;

import java.util.*;

public class MapExample {
    public static void main(String[] args) {

        // Example of HashMap (unordered)
        System.out.println("HashMap:");
        Map<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "One");
        hashMap.put(2, "Two");
        hashMap.put(3, "Three");
        hashMap.put(4, "Four");
        hashMap.put(5, "Five");

        for (Map.Entry<Integer, String> entry : hashMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        System.out.println();

        // Example of TreeMap (ordered by key)
        System.out.println("TreeMap:");
        Map<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(1, "One");
        treeMap.put(2, "Two");
        treeMap.put(3, "Three");
        treeMap.put(4, "Four");
        treeMap.put(5, "Five");

        for (Map.Entry<Integer, String> entry : treeMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        System.out.println();

        // Example of LinkedHashMap (maintains insertion order)
        System.out.println("LinkedHashMap:");
        Map<Integer, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(1, "One");
        linkedHashMap.put(2, "Two");
        linkedHashMap.put(3, "Three");
        linkedHashMap.put(4, "Four");
        linkedHashMap.put(5, "Five");

        for (Map.Entry<Integer, String> entry : linkedHashMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        System.out.println();

        // Example of Hashtable (synchronized)
        System.out.println("Hashtable:");
        Map<Integer, String> hashtable = new Hashtable<>();
        hashtable.put(1, "One");
        hashtable.put(2, "Two");
        hashtable.put(3, "Three");
        hashtable.put(4, "Four");
        hashtable.put(5, "Five");

        for (Map.Entry<Integer, String> entry : hashtable.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
