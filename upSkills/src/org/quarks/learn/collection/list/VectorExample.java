package org.quarks.learn.collection.list;

import java.util.Vector;

public class VectorExample {
    public static void main(String[] args) {
        // Create a Vector of Strings
        Vector<String> fruits = new Vector<>();

        // Add elements to the Vector
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");
        fruits.add("Date");

        // Display the Vector
        System.out.println("Fruits Vector: " + fruits);

        // Add an element at a specific index
        fruits.add(2, "Mango");
        System.out.println("After adding Mango at index 2: " + fruits);

        // Remove an element by index
        fruits.remove(1); // Removes "Banana"
        System.out.println("After removing the element at index 1: " + fruits);

        // Get an element by index
        System.out.println("Element at index 2: " + fruits.get(2));

        // Check if the Vector contains a specific element
        if (fruits.contains("Cherry")) {
            System.out.println("Cherry is in the vector.");
        } else {
            System.out.println("Cherry is not in the vector.");
        }

        // Get the size of the Vector
        System.out.println("Size of the vector: " + fruits.size());

        // Iterate through the Vector using a for loop
        System.out.println("Iterating through the vector:");
        for (int i = 0; i < fruits.size(); i++) {
            System.out.println(fruits.get(i));
        }

        // Clear all elements from the Vector
        fruits.clear();
        System.out.println("After clearing the vector: " + fruits);
    }
}

