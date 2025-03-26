package org.quarks.pract.test;

public class QuickSortExample {

    // Function to swap two elements
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Function to partition the array
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // Choose the last element as the pivot
        int i = low - 1; // Index of smaller element

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) { // If current element is smaller than the pivot
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high); // Swap pivot to its correct position
        return i + 1;
    }

    // Function to perform QuickSort

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(arr, low, high);

            // Recursively sort elements before and after partition
            quickSort(arr, low, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, high);
        }
    }





    // Main function to test QuickSort
    public static void main(String[] args) {
        int[] arr = { 10, 7, 8, 9, 1, 5 };
        int n = arr.length;

        System.out.println("Original Array:");
        printArray(arr);

        quickSort(arr, 0, n - 1);

        System.out.println("Sorted Array:");
        printArray(arr);
    }

    // Function to print an array
    private static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
