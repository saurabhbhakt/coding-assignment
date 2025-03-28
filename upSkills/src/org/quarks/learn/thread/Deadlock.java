package org.quarks.learn.thread;

class Deadlock {
    static final Object lock1 = new Object();
    static final Object lock2 = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            synchronized (lock1) {
                System.out.println("Thread 1: Holding lock1...");
                synchronized (lock2) { // Waiting for lock2
                    System.out.println("Thread 1: Acquired lock2...");
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (lock2) {
                System.out.println("Thread 2: Holding lock2...");
                synchronized (lock1) { // Waiting for lock1
                    System.out.println("Thread 2: Acquired lock1...");
                }
            }
        });

        t1.start();
        t2.start();
    }
}
