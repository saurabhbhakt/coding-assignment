package org.quarks.learn.synchronizers;

import java.util.concurrent.Exchanger;
import java.util.List;
import java.util.ArrayList;

public class ExchangerExample {
    public static void main(String[] args) throws InterruptedException {
        // Create an Exchanger to exchange a list of numbers
        Exchanger<List<Integer>> exchanger = new Exchanger<>();

        // Create and start the first thread (Producer - generating numbers)
        Thread producer = new Thread(new Producer(exchanger));
        producer.start();

        // Create and start the second thread (Consumer - processing numbers)
        Thread consumer = new Thread(new Consumer(exchanger));
        consumer.start();
    }
}

class Producer implements Runnable {
    private final Exchanger<List<Integer>> exchanger;

    public Producer(Exchanger<List<Integer>> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        // Step 1: Generate some data (in this case, a list of integers)
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            numbers.add(i);  // Add numbers to the list
        }

        // Step 2: Exchange data with the consumer thread
        try {
            System.out.println("Producer: Generated numbers, ready to exchange.");
            // First exchange - send the data to the consumer
            exchanger.exchange(numbers);  // Exchange data with the consumer
            System.out.println("Producer: Data Send : " + numbers);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Consumer implements Runnable {
    private final Exchanger<List<Integer>> exchanger;

    public Consumer(Exchanger<List<Integer>> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        // Step 1: Wait for data from the producer
        List<Integer> dataFromProducer = null;
        try {
            dataFromProducer = exchanger.exchange(null);  // Wait for data from producer
            System.out.println("Consumer: Received numbers from producer: " + dataFromProducer);

            // Step 2: Process the data (double each number in the list)
            List<Integer> processedData = new ArrayList<>();
            for (Integer number : dataFromProducer) {
                processedData.add(number * 2);  // Process data (e.g., double the numbers)
            }
            System.out.println(processedData);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
