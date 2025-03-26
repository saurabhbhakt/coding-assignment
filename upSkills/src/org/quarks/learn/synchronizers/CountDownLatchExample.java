package org.quarks.learn.synchronizers;

import java.util.concurrent.CountDownLatch;

/**
 * Use Case:A scenario where you need to wait for multiple background tasks to complete before performing a final operation.
 * For example:
 * -
 * Running several independent tests in parallel and waiting for all of them to finish before reporting the results.
 * -
 * Performing data processing tasks in parallel and ensuring all tasks are completed before consolidating the results.
 */
public class CountDownLatchExample {
    public static void main(String[] args) throws InterruptedException {
        // Step 1: Create a CountDownLatch initialized to 3 (3 tasks)
        CountDownLatch latch = new CountDownLatch(3);

        // Step 2: Create and start 3 worker threads
        Thread worker1 = new Thread(new WorkerTask(latch, "Worker 1"));
        Thread worker2 = new Thread(new WorkerTask(latch, "Worker 2"));
        Thread worker3 = new Thread(new WorkerTask(latch, "Worker 3"));

        worker1.start();
        worker2.start();
        worker3.start();

        // Step 3: Main thread waits until the count reaches zero
        System.out.println("Main thread is waiting for workers to finish...");
        latch.await(); // Wait for the latch count to reach 0

        // Step 4: Once all worker threads are done, main thread proceeds
        System.out.println("All workers are done. Main thread proceeding...");
    }
}

class WorkerTask implements Runnable {
    private final CountDownLatch latch;
    private final String name;

    public WorkerTask(CountDownLatch latch, String name) {
        this.latch = latch;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            System.out.println(name + " is working...");
            Thread.sleep((long) (Math.random() * 1000)); // Simulate work by sleeping
            System.out.println(name + " has finished work.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            latch.countDown(); // Decrease the latch count by 1
        }
    }
}
