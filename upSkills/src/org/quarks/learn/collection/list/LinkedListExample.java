package org.quarks.learn.collection.list;

import java.util.LinkedList;

public class LinkedListExample {
    public static void main(String[] args) {
        // Create a LinkedList of Strings
        LinkedList<String> fruits = new LinkedList<>();

        // Add elements to the LinkedList
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");
        fruits.add("Date");

        // Display the LinkedList
        System.out.println("Fruits LinkedList: " + fruits);

        // Add an element at the first position
        fruits.addFirst("Mango");
        System.out.println("After adding Mango at the beginning: " + fruits);

        // Add an element at the last position
        fruits.addLast("Orange");
        System.out.println("After adding Orange at the end: " + fruits);

        // Remove the first element
        fruits.removeFirst();
        System.out.println("After removing the first element: " + fruits);

        // Remove the last element
        fruits.removeLast();
        System.out.println("After removing the last element: " + fruits);

        // Get the first element
        System.out.println("First fruit: " + fruits.getFirst());

        // Get the last element
        System.out.println("Last fruit: " + fruits.getLast());

        // Check if an element exists
        if (fruits.contains("Banana")) {
            System.out.println("Banana is in the list.");
        } else {
            System.out.println("Banana is not in the list.");
        }

        // Iterating through the LinkedList
        System.out.println("Iterating through the list:");
        for (String fruit : fruits) {
            System.out.println(fruit);
        }
    }
}

