package org.quarks.learn.thread.creatingThreads;

class MyRunnable implements Runnable {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getId() + " Value " + i);
        }
    }

    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        Thread t1 = new Thread(myRunnable);  // Create thread with Runnable object
        Thread t2 = new Thread(myRunnable);

        t1.start();  // Start the thread
        t2.start();  // Start the thread
    }
}

