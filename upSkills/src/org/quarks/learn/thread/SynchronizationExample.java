package org.quarks.learn.thread;

class Counter {
    private int count = 0;

    public synchronized void increment() {
        count++;
        System.out.println("thread : "+ Thread.currentThread().getName() +" counter is "+ count);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public synchronized int getCount() {
        return count;
    }
}

/***
 * The increment() method is synchronized, meaning only one thread can execute it at a time.
 * The join() method is used to ensure the main thread waits for t1 and t2 to complete before printing the final count.
 */
public class SynchronizationExample {
    public static void main(String[] args) {
        Counter counter = new Counter();

        // Creating two threads that increment the counter
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                counter.increment();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                counter.increment();
            }
        });

        t1.start();  // Start thread t1
        t2.start();  // Start thread t2

        try {
            t1.join();  // Wait for t1 to finish
            t2.join();  // Wait for t2 to finish
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final count: " + counter.getCount());  // Expected output: 2000
    }
}

