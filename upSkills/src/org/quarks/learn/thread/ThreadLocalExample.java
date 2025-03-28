package org.quarks.learn.thread;

import java.util.concurrent.atomic.AtomicInteger;

class ThreadLocalExample {
    static ThreadLocal<Integer> threadLocalValue = ThreadLocal.withInitial(() -> 0);
    static AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            threadLocalValue.set(100);
            atomicInteger.set(100);
            System.out.println("Thread 1: threadLocalValue : " + threadLocalValue.get());
            System.out.println("Thread 1: atomicInteger : " + atomicInteger.get());
        });

        Thread t2 = new Thread(() -> {
            threadLocalValue.set(200);
            atomicInteger.set(200);
            System.out.println("Thread 2: threadLocalValue : " + threadLocalValue.get());
            System.out.println("Thread 2: atomicInteger : " + atomicInteger.get());
        });

        t1.start();
        t2.start();
    }
}

