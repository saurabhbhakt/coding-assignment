package org.quarks.learn.thread.pool;

import java.util.concurrent.RecursiveTask;
import java.util.concurrent.ForkJoinPool;

public class ParallelMergeSort {

    // RecursiveTask for merge sort
    static class MergeSortTask extends RecursiveTask<int[]> {
        private final int[] array;
        private final int start;
        private final int end;

        public MergeSortTask(int[] array, int start, int end) {
            this.array = array;
            this.start = start;
            this.end = end;
        }

        @Override
        protected int[] compute() {
            // Base case: If the array has only one element, return it
            if (end - start <= 1) {
                return new int[]{array[start]};
            }

            // Split the array into two halves
            int mid = (start + end) / 2;
            MergeSortTask leftTask = new MergeSortTask(array, start, mid);
            MergeSortTask rightTask = new MergeSortTask(array, mid, end);

            // Fork the left and right tasks (execute in parallel)
            leftTask.fork();
            rightTask.fork();

            // Wait for the results of the left and right tasks
            int[] leftResult = leftTask.join();
            int[] rightResult = rightTask.join();

            // Merge the two sorted halves
            return merge(leftResult, rightResult);
        }

        // Merge two sorted arrays
        private int[] merge(int[] left, int[] right) {
            int[] result = new int[left.length + right.length];
            int i = 0, j = 0, k = 0;

            // Merge the two arrays
            while (i < left.length && j < right.length) {
                if (left[i] < right[j]) {
                    result[k++] = left[i++];
                } else {
                    result[k++] = right[j++];
                }
            }

            // Copy remaining elements from left array
            while (i < left.length) {
                result[k++] = left[i++];
            }

            // Copy remaining elements from right array
            while (j < right.length) {
                result[k++] = right[j++];
            }

            return result;
        }
    }

    public static void main(String[] args) {
        // Example array to be sorted
        int[] array = {7, 3, 2, 8, 6, 5, 1, 4};

        // Create a ForkJoinPool
        ForkJoinPool pool = new ForkJoinPool();

        // Create a MergeSortTask for the entire array
        MergeSortTask task = new MergeSortTask(array, 0, array.length);

        // Invoke the task using the ForkJoinPool
        int[] sortedArray = pool.invoke(task);

        // Print the sorted array
        System.out.println("Sorted Array: ");
        for (int num : sortedArray) {
            System.out.print(num + " ");
        }

        pool.shutdown(); // Shutdown the pool after execution
    }
}

