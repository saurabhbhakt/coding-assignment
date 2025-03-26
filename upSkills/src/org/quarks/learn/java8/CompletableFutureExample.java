package org.quarks.learn.java8;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureExample {
    public static void main(String[] args) throws Exception {
        // Create a CompletableFuture that computes a result asynchronously
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000); // Simulating a long-running task
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            return "Hello, World!";
        });

        // Manually complete the CompletableFuture
        future.thenAccept(result -> System.out.println("Result: " + result));

        // Wait for the completion of the computation
        future.get();
    }
}
