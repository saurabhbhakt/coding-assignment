package org.quarks.learn.synchronizers;

import java.util.concurrent.Semaphore;

/**
 * Semaphore controls access to a set of resources (in this case, database connections). It ensures that only a fixed number of threads can access a shared resource concurrently.
 * Threads that try to acquire a resource (a permit) when no permits are available will block until another thread releases a permit.
 * The Semaphore can be used for various scenarios like managing connections to a database, limiting access to a file, or controlling the number of threads accessing a critical section.
 */
public class SemaphoreExample {
    public static void main(String[] args) {
        // Step 1: Create a Semaphore with 5 available permits (database connections)
        Semaphore semaphore = new Semaphore(5);  // Only 5 connections available

        // Step 2: Create and start 10 worker threads (simulating database usage)
        for (int i = 1; i <= 10; i++) {
            new Thread(new DatabaseTask(semaphore, "Worker " + i)).start();
        }
    }
}

class DatabaseTask implements Runnable {
    private final Semaphore semaphore;
    private final String workerName;

    public DatabaseTask(Semaphore semaphore, String workerName) {
        this.semaphore = semaphore;
        this.workerName = workerName;
    }

    @Override
    public void run() {
        try {
            // Step 3: Try to acquire a database connection (permit)
            System.out.println(workerName + " is trying to access the database...");

            semaphore.acquire();  // Acquire a permit (database connection)

            System.out.println(workerName + " has accessed the database.");

            // Simulate using the database (sleep for a random time)
            Thread.sleep((long) (Math.random() * 5000));

            // Step 4: Release the database connection (permit)
            System.out.println(workerName + " is releasing the database connection.");
            semaphore.release();  // Release the permit

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
