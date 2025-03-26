package org.quarks.learn.synchronizers;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class BankAccount {
    private int balance;
    private final Lock lock = new ReentrantLock();  // ReentrantLock to protect the balance

    public BankAccount(int balance) {
        this.balance = balance;
    }

    // Method to deposit money
    public void deposit(int amount) {
        lock.lock();  // Acquire the lock
        try {
            System.out.println(Thread.currentThread().getName() + " is depositing " + amount);
            balance += amount;  // Critical section
        } finally {
            lock.unlock();  // Always unlock in the 'finally' block to ensure the lock is released
        }
    }

    // Method to withdraw money
    public void withdraw(int amount) {
        lock.lock();  // Acquire the lock
        try {
            if (balance >= amount) {
                System.out.println(Thread.currentThread().getName() + " is withdrawing " + amount);
                balance -= amount;  // Critical section
            } else {
                System.out.println(Thread.currentThread().getName() + " insufficient balance to withdraw " + amount);
            }
        } finally {
            lock.unlock();  // Always unlock in the 'finally' block
        }
    }

    public int getBalance() {
        return balance;
    }
}

public class LockExample {
    public static void main(String[] args) {
        // Create a shared BankAccount with an initial balance of 1000
        BankAccount account = new BankAccount(1000);

        // Create two threads that perform deposit and withdrawal operations
        Thread t1 = new Thread(() -> {
            account.deposit(500);
            account.withdraw(200);
        }, "Thread-1");

        Thread t2 = new Thread(() -> {
            account.deposit(300);
            account.withdraw(700);
        }, "Thread-2");

        Thread t3 =  new Thread(()-> account.withdraw(100), "t-3");

        // Start the threads
        t1.start();
        t2.start();
        t3.start();

        // Wait for both threads to finish
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Print final balance
        System.out.println("Final balance: " + account.getBalance());
    }
}
