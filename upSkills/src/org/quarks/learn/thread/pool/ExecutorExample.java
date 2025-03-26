package org.quarks.learn.thread.pool;

import java.util.concurrent.*;

/**
 * Executors.newFixedThreadPool(4) creates a thread pool with 4 threads.
 * The submit method is used to submit tasks for execution.
 */
public class ExecutorExample {
    public static void main(String[] args)  {
        ExecutorService executorService = Executors.newFixedThreadPool(4); // Create a thread pool with 4 threads

        Runnable task = () -> {
            System.out.println(Thread.currentThread().getName() + " is executing the task.");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        for (int i = 0; i < 10; i++) {
            executorService.submit(task); // Submit tasks to the executor service
        }

        executorService.shutdown(); // Gracefully shutdown the executor
    }
}

