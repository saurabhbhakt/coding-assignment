package org.quarks.learn.thread;

import java.util.concurrent.CompletableFuture;

class CompletableFutureExample {
    public static void main(String[] args) {
        CompletableFuture.supplyAsync(() -> "Hello, Async World!").thenAccept(System.out::println);

        System.out.println("Main thread is free...");
    }
}

