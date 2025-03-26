package org.quarks.learn.collection.queue;

import java.util.*;

public class QueueListExample {
    public static void main(String[] args) {

        // Example of LinkedList
        System.out.println("LinkedList:");
        List<String> linkedList = new LinkedList<>();
        linkedList.add("Apple");
        linkedList.add("Banana");
        linkedList.add("Cherry");
        linkedList.add("Date");

        // Iterate using for-each loop
        for (String item : linkedList) {
            System.out.println(item);
        }

        System.out.println();

        // Example of PriorityQueue (min-heap by default)
        System.out.println("PriorityQueue:");
        Queue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(10);
        priorityQueue.add(30);
        priorityQueue.add(20);
        priorityQueue.add(50);
        priorityQueue.add(40);

        // Removing elements from PriorityQueue (automatically sorted)
        while (!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.poll());
        }

        System.out.println();

        // Example of ArrayDeque (used as a stack or queue)
        System.out.println("ArrayDeque:");
        Deque<String> arrayDeque = new ArrayDeque<>();
        arrayDeque.add("One");
        arrayDeque.add("Two");
        arrayDeque.add("Three");
        arrayDeque.add("Four");

        // Using ArrayDeque as a Queue (FIFO)
        System.out.println("Deque as Queue (FIFO):");
        while (!arrayDeque.isEmpty()) {
            System.out.println(arrayDeque.poll()); // poll() removes and returns the first element
        }

        System.out.println();

        // Using ArrayDeque as a Stack (LIFO)
        arrayDeque.push("One");
        arrayDeque.push("Two");
        arrayDeque.push("Three");
        arrayDeque.push("Four");

        System.out.println("Deque as Stack (LIFO):");
        while (!arrayDeque.isEmpty()) {
            System.out.println(arrayDeque.pop()); // pop() removes and returns the first element
        }
    }
}