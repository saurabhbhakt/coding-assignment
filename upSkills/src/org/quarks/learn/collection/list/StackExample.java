package org.quarks.learn.collection.list;

import java.util.Stack;

public class StackExample {
    public static void main(String[] args) {
        // Create a Stack of Strings
        Stack<String> stack = new Stack<>();

        // Push elements onto the stack
        stack.push("Apple");
        stack.push("Banana");
        stack.push("Cherry");
        stack.push("Date");

        // Display the Stack
        System.out.println("Stack after pushing elements: " + stack);

        // Peek at the top element (without removing it)
        System.out.println("Top element (peek): " + stack.peek());

        // Pop the top element off the stack
        System.out.println("Popped element: " + stack.pop());

        // Display the Stack after popping
        System.out.println("Stack after popping an element: " + stack);

        // Check if the stack is empty
        System.out.println("Is the stack empty? " + stack.isEmpty());

        // Search for an element in the stack (returns the 1-based position from the top)
        int position = stack.search("Banana");
        if (position != -1) {
            System.out.println("Banana is at position: " + position);
        } else {
            System.out.println("Banana is not in the stack.");
        }

        // Iterate through the Stack using a for loop
        System.out.println("Iterating through the stack:");
        for (String fruit : stack) {
            System.out.println(fruit);
        }

        // Clear the stack
        stack.clear();
        System.out.println("Stack after clearing: " + stack);
    }
}
