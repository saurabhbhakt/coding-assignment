package org.quarks.learn.thread;

import java.util.concurrent.*;

public class SingleThreadExecutorExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        singleThredExecuter();
        callable();

    }

    private static void callable() throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Callable<Integer> task = () -> 10 * 10;
        Future<Integer> future = executor.submit(task);

        System.out.println("Result: " + future.get()); // Output: 100
        executor.shutdown();
    }

    private static void singleThredExecuter() {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        Runnable task1 = () -> {
            System.out.println(Thread.currentThread().getName() + " - Executing Task 1");
        };

        Runnable task2 = () -> {
            System.out.println(Thread.currentThread().getName() + " - Executing Task 2");
        };

        Runnable task3 = () -> {
            System.out.println(Thread.currentThread().getName() + " - Executing Task 3");
        };

        executor.submit(task1);
        executor.submit(task2);
        executor.submit(task3);

        executor.shutdown(); // Initiates an orderly shutdown
    }
}

