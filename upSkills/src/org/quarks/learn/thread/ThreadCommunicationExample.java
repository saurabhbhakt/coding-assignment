package org.quarks.learn.thread;

/***
 * The produce() and consume() methods use wait() and notify() to coordinate when one thread produces and another consumes.
 * This ensures that both threads cooperate in producing and consuming items at the right times.
 */
class SharedResource {
    private boolean ready = false;

    public synchronized void produce() throws InterruptedException {
        while (!ready) {
            wait();  // Wait until ready becomes true
        }
        System.out.println("Producing item...");
        ready = false;
        notify();  // Notify the consumer thread
    }

    public synchronized void consume() throws InterruptedException {
        System.out.println("Waiting to consume...");
        ready = true;
        notify();  // Notify the producer thread
        wait();  // Wait until the producer has finished
        System.out.println("Consuming item...");
    }
}

public class ThreadCommunicationExample {
    public static void main(String[] args) throws InterruptedException {
        SharedResource resource = new SharedResource();

        // Producer thread
        Thread producer = new Thread(() -> {
            try {
                resource.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // Consumer thread
        Thread consumer = new Thread(() -> {
            try {
                resource.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        producer.start();
        consumer.start();

        producer.join();
        consumer.join();
    }
}
