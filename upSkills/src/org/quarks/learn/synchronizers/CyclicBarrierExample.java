package org.quarks.learn.synchronizers;

import java.util.concurrent.CyclicBarrier;

/**
 * CyclicBarrier allows multiple threads to synchronize at a common barrier point, waiting until all threads have arrived. After all threads reach the barrier, they can proceed together.
 * The barrier can be reused after all threads have crossed, which is why it's called "cyclic."
 * It is useful when you have multiple threads working on different parts of a task and you want to make sure that they all synchronize at certain points before continuing.
 */
public class CyclicBarrierExample {
    public static void main(String[] args) {
        // Step 1: Create a CyclicBarrier with 3 parties (threads)
        CyclicBarrier barrier = new CyclicBarrier(3, new Runnable() {
            @Override
            public void run() {
                // This will be executed after all threads reach the barrier
                System.out.println("All workers have completed this task. Proceeding to next task...");
            }
        });

        // Step 2: Create and start 3 worker threads
        Thread worker1 = new Thread(new Worker(barrier, "Worker 1"));
        Thread worker2 = new Thread(new Worker(barrier, "Worker 2"));
        Thread worker3 = new Thread(new Worker(barrier, "Worker 3"));

        worker1.start();
        worker2.start();
        worker3.start();
    }
}

class Worker implements Runnable {
    private final CyclicBarrier barrier;
    private final String name;

    public Worker(CyclicBarrier barrier, String name) {
        this.barrier = barrier;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            // task 1: Simulate work in task 1
            taskOne();

            // Wait at the barrier after completing task 1
            barrier.await(); // This will block until all threads reach the barrier

            // task 2: Simulate work in task 2
            taskTwo();

            // Wait at the barrier after completing task 2
            barrier.await(); // Wait for other threads to finish task 2
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void taskOne() throws InterruptedException {
        System.out.println(name + " is working on task 1...");
        Thread.sleep((long) (Math.random() * 1000)); // Simulate some work
        System.out.println(name + " completed task 1.");
    }

    private void taskTwo() throws InterruptedException {
        System.out.println(name + " is working on task 2...");
        Thread.sleep((long) (Math.random() * 1000)); // Simulate some work
        System.out.println(name + " completed task 2.");
    }
}
