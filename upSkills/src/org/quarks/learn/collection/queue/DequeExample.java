package org.quarks.learn.collection.queue;

import java.util.*;

public class DequeExample {
    public static void main(String[] args) {
        Deque<String> deque = new ArrayDeque<>();
        deque.addFirst("Apple");
        deque.addLast("Banana");

        // Remove from the front and end
        System.out.println("Removed from front: " + deque.removeFirst());
        System.out.println("Removed from end: " + deque.removeLast());
    }
}

