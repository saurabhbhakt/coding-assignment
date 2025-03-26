package org.quarks.learn.collection.concurrent;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * CopyOnWriteArrayList ensures that threads can read the list safely even while other threads are modifying it.
 * Every modification creates a new copy of the underlying array, which makes it efficient for scenarios where reads outnumber writes.
 */

public class CopyOnWriteArrayListExample {
    public static void main(String[] args) throws InterruptedException {
        // Create a CopyOnWriteArrayList
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();

        // Thread 1: Adds elements to the list
        Runnable task1 = () -> {
            for (int i = 0; i < 5; i++) {
                list.add("Thread 1 - " + i);
                System.out.println("Thread 1 added: Thread 1 - " + i);
            }
        };

        // Thread 2: Adds elements to the list
        Runnable task2 = () -> {
            for (int i = 5; i < 10; i++) {
                list.add("Thread 2 - " + i);
                System.out.println("Thread 2 added: Thread 2 - " + i);
            }
        };

        // Start threads
        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2);
        thread1.start();
        thread2.start();

        // Wait for both threads to finish
        thread1.join();
        thread2.join();

        // Print the final list
        System.out.println("Final list: " + list);
    }
}

