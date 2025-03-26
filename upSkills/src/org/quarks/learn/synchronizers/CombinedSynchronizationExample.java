package org.quarks.learn.synchronizers;

import java.util.concurrent.*;
import java.util.concurrent.locks.*;

class SharedCounter {
    private int counter = 0;
    private final ReentrantLock lock = new ReentrantLock();

    // Method to increment the counter
    public void increment() {
        lock.lock();
        try {
            counter++;
        } finally {
            lock.unlock();
        }
    }

    // Method to double the counter
    public void doubleCounter() {
        lock.lock();
        try {
            counter *= 2;
        } finally {
            lock.unlock();
        }
    }

    // Method to get the final value of the counter
    public int getCounter() {
        return counter;
    }
}

class SyncWorker implements Runnable {
    private final SharedCounter counter;
    private final CyclicBarrier barrier;
    private final CountDownLatch latch;
    private final Phaser phaser;
    private final Semaphore semaphore;
    private final int workerId;

    public SyncWorker(SharedCounter counter, CyclicBarrier barrier, CountDownLatch latch, Phaser phaser, Semaphore semaphore, int workerId) {
        this.counter = counter;
        this.barrier = barrier;
        this.latch = latch;
        this.phaser = phaser;
        this.semaphore = semaphore;
        this.workerId = workerId;
    }

    @Override
    public void run() {
        try {
            // Phase 1: Increment the counter (Access controlled by Semaphore)
            semaphore.acquire();  // Limit the number of threads accessing this section
            System.out.println("Worker " + workerId + " is incrementing the counter.");
            counter.increment();
            semaphore.release();  // Release the semaphore

            phaser.arriveAndAwaitAdvance();  // Synchronize with other threads

            // Phase 2: Double the counter
            semaphore.acquire();  // Limit the number of threads accessing this section
            System.out.println("Worker " + workerId + " is doubling the counter.");
            counter.doubleCounter();
            semaphore.release();  // Release the semaphore

            phaser.arriveAndAwaitAdvance();  // Synchronize with other threads

            // Phase 3: Finalize and signal the latch
            System.out.println("Worker " + workerId + " has completed the task.");
            latch.countDown();  // Signal the latch that this worker has finished
            phaser.arriveAndAwaitAdvance();  // Synchronize with other threads

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class CombinedSynchronizationExample {
    public static void main(String[] args) {
        // Number of workers
        int numWorkers = 3;

        // Shared counter object
        SharedCounter counter = new SharedCounter();

        // Barrier to synchronize workers at the end of each phase
        CyclicBarrier barrier = new CyclicBarrier(numWorkers, () -> {
            System.out.println("All workers have completed a phase. Moving to the next phase.");
        });

        // Latch to wait for all workers to finish before printing the result
        CountDownLatch latch = new CountDownLatch(numWorkers);

        // Phaser to synchronize workers across multiple phases
        Phaser phaser = new Phaser(1); // Start with 1 party (the main thread)

        // Semaphore to limit access to a resource (e.g., a pool of resources)
        Semaphore semaphore = new Semaphore(1);  // Only 1 worker can access the counter at a time

        // Create and start worker threads
        for (int i = 0; i < numWorkers; i++) {
            new Thread(new SyncWorker(counter, barrier, latch, phaser, semaphore, i + 1)).start();
            phaser.register();  // Register each worker in the Phaser
        }

        // Wait for all workers to complete
        try {
            latch.await();  // Wait until all workers are done
            System.out.println("Final counter value: " + counter.getCounter());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
