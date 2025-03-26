package org.quarks.learn.collection.concurrent;

import java.util.concurrent.*;

/**
 * ConcurrentHashMap allows multiple threads to add elements concurrently.
 * ALL task1, task2 and task3 attempt to add keys concurrently.
 * The ConcurrentHashMap ensures thread-safety without blocking reads or writes entirely.
 */
public class ConcurrentHashMapExample {

    public static void main(String[] args) throws InterruptedException {
        // Create a ConcurrentHashMap
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();

        // Create tasks that will run concurrently
        Runnable task1 = () -> {
            for (int i = 0; i < 30; i++) {
                map.putIfAbsent("key" + i, i); // Add key-value pair if key is absent
                System.out.println("Thread 1 added: key" + i + " => " + i);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Runnable task2 = () -> {
            for (int i = 5; i < 35; i++) {
                map.putIfAbsent("key" + i, i); // Add key-value pair if key is absent
                System.out.println("Thread 2 added: key" + i + " => " + i);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Runnable task3 = () -> {
            for (int i = 3; i < 33; i++) {
                map.putIfAbsent("key" + i, i); // Add key-value pair if key is absent
                System.out.println("Thread 2 added: key" + i + " => " + i);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        // Create two threads that will modify the map concurrently
        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2);
        Thread thread3 = new Thread(task3);

        // Start both threads
        thread1.start();
        thread2.start();
        thread3.start();

        // Wait for both threads to complete
        thread1.join();
        thread2.join();
        thread3.join();

        // Print the final state of the map
        System.out.println("Final map: " + map);
    }
}

