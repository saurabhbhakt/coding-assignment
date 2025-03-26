package org.quarks.learn.collection.concurrent;

import java.util.concurrent.*;

/**
 * Producer: The producer thread produces data and adds it to the BlockingQueue. It uses the put() method, which blocks if the queue is full.
 * Consumer: The consumer thread consumes data from the queue using the take() method, which blocks if the queue is empty.
 * Blocking Behavior: BlockingQueue ensures that the producer waits if the queue is full, and the consumer waits if the queue is empty.
 */

public class BlockingQueueExample {
    public static void main(String[] args) throws InterruptedException {
        // Create a BlockingQueue with a capacity of 10
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);

        // Producer thread: Adds elements to the queue
        Runnable producer = () -> {
            try {
                for (int i = 0; i < 10; i++) {
                    queue.put(i);  // Blocks if the queue is full
                    System.out.println("Produced: " + i);
                    Thread.sleep(100);  // Simulate time taken to produce an item
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        };

        // Consumer thread: Takes elements from the queue
        Runnable consumer = () -> {
            try {
                for (int i = 0; i < 10; i++) {
                    Integer item = queue.take();  // Blocks if the queue is empty
                    System.out.println("Consumed: " + item);
                    Thread.sleep(150);  // Simulate time taken to consume an item
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        };

        // Start producer and consumer threads
        Thread producerThread = new Thread(producer);
        Thread consumerThread = new Thread(consumer);
        producerThread.start();
        consumerThread.start();

        // Wait for both threads to finish
        producerThread.join();
        consumerThread.join();
    }
}

