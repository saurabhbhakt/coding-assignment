package org.quarks.pract.atm;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

class ATMAccount {
    private AtomicInteger balance;
    private final Object lock = new Object();

    public ATMAccount(int initialBalance) {
        this.balance = new AtomicInteger(initialBalance);
    }

    // Method to withdraw money
    public boolean withdraw(int amount) throws InterruptedException {
        synchronized (lock) {
            // If insufficient balance, wait until balance is enough
            while (balance.get() < amount) {
                System.out.println(Thread.currentThread().getName() + " is waiting, insufficient balance.");
                lock.wait();  // Wait for sufficient balance
            }

            // If sufficient balance, withdraw the amount
            balance.addAndGet(-amount);
            System.out.println(Thread.currentThread().getName() + " withdrew " + amount + ", remaining balance: " + balance.get());

            return true;
        }
    }

    // Method to deposit money
    public void deposit(int amount) {
        synchronized (lock) {
            balance.addAndGet(amount);
            lock.notifyAll();  // Notify all waiting threads that balance has been updated
            System.out.println("Deposited " + amount + ", new balance: " + balance.get());
        }
    }

    public int getBalance() {
        return balance.get();
    }
}

class UserTask implements Runnable {
    private final ATMAccount atmAccount;
    private final int withdrawalAmount;
    private final CountDownLatch latch;

    public UserTask(ATMAccount atmAccount, int withdrawalAmount, CountDownLatch latch) {
        this.atmAccount = atmAccount;
        this.withdrawalAmount = withdrawalAmount;
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            // Try to withdraw money from ATM
            boolean success = atmAccount.withdraw(withdrawalAmount);
            if (success) {
                System.out.println(Thread.currentThread().getName() + " completed transaction.");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            latch.countDown();  // Decrement the latch when done
        }
    }
}

public class ATMSystem {
    public static void main(String[] args) {
        // Create ATM account with an initial balance of 1000
        ATMAccount atmAccount = new ATMAccount(1000);

        // Create a CountDownLatch to wait for all users to complete
        int numberOfUsers = 5;
        CountDownLatch latch = new CountDownLatch(numberOfUsers);

        // Executor service to manage threads
        ExecutorService executorService = Executors.newFixedThreadPool(numberOfUsers);

        // Create and submit tasks (UserThreads)
        for (int i = 0; i < numberOfUsers; i++) {
            int withdrawalAmount = (i + 1) * 200;  // Withdraw an increasing amount for each user
            executorService.submit(new UserTask(atmAccount, withdrawalAmount, latch));
        }

        // Simulate deposit after some time to allow users to proceed
        new Thread(() -> {
            try {
                Thread.sleep(3000);  // Simulate waiting time before deposit
                atmAccount.deposit(2000);  // Deposit 1000 to allow users to complete their transactions
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        try {
            // Wait for all users to complete their transactions
            latch.await();
            System.out.println("All transactions completed. with balance : " + atmAccount.getBalance());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();  // Shut down the executor service
        }

        // Print final ATM balance
        System.out.println("Final ATM balance: " + atmAccount.getBalance());
    }
}

