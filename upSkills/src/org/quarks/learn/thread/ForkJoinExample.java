package org.quarks.learn.thread;

import java.util.concurrent.*;
import java.util.stream.IntStream;

class SumTask extends RecursiveTask<Integer> {
    int start, end;

    SumTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    protected Integer compute() {
        System.out.println("start : "+ start + " end : "+end);
        if (end - start <= 10) {
            return IntStream.rangeClosed(start, end).sum();
        }
        int mid = (start + end) / 2;
        SumTask leftTask = new SumTask(start, mid);
        SumTask rightTask = new SumTask(mid + 1, end);
        leftTask.fork();
        return rightTask.compute() + leftTask.join();
    }
}

public class ForkJoinExample {
    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        int result = pool.invoke(new SumTask(1, 100));
        System.out.println("Sum: " + result);
    }
}

