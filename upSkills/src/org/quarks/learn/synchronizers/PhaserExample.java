package org.quarks.learn.synchronizers;

import java.util.concurrent.Phaser;

public class PhaserExample {
    public static void main(String[] args) {
        // Number of workers/threads
        int numberOfWorkers = 3;

        // Create a Phaser with the initial number of parties (main thread is counted)
        Phaser phaser = new Phaser(0); // Main thread is the first participant

        // Create and start threads (workers)
        for (int i = 0; i < numberOfWorkers; i++) {
            new Thread(new PhaseWorker(phaser, i + 1)).start();
        }
    }
}

class PhaseWorker implements Runnable {
    private final Phaser phaser;
    private final int workerId;

    public PhaseWorker(Phaser phaser, int workerId) {
        this.phaser = phaser;
        this.workerId = workerId;
        this.phaser.register();
    }

    @Override
    public void run() {
        try {
            phase1();
            phaser.arriveAndAwaitAdvance();  // Synchronize at the end of Phase 3

            phase2();
            phaser.arriveAndAwaitAdvance();  // Synchronize at the end of Phase 2

            phase3();
            phaser.arriveAndAwaitAdvance();  // Synchronize at the end of Phase 1

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // Deregister the worker from the phaser when done
            phaser.arriveAndDeregister();
        }
    }

    private void phase3() throws InterruptedException {
        // Phase 3: Finalize work
        System.out.println("Worker " + workerId + " is finalizing work.");
        Thread.sleep(1000);  // Simulate work

    }

    private void phase2() throws InterruptedException {
        // Phase 2: Process data
        System.out.println("Worker " + workerId + " is processing data.");
        Thread.sleep(1000);  // Simulate work
    }

    private void phase1() throws InterruptedException {
        // Phase 1: Prepare data
        System.out.println("Worker " + workerId + " is preparing data.");
        Thread.sleep(1000);  // Simulate work
    }
}