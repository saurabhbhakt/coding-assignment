package org.quarks.pract.test;

public class PerfectNumberFinder {
    public static boolean isPerfectNumber(int num) {
        if (num < 2) {
            return false;
        }

        int sum = 1; // 1 is always a divisor
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                sum += i;
            }
        }

        return sum == num;
    }

    public static void main(String[] args) {
        int number = Integer.parseInt(args[0]); // Change this to test other numbers

        if (isPerfectNumber(number)) {
            System.out.println(number + " is a perfect number.");
        } else {
            System.out.println(number + " is not a perfect number.");
        }

        // Finding all perfect numbers up to 10,000
        System.out.println("Perfect numbers up to 10,000:");
        for (int i = 1; i <= 10000; i++) {
            if (isPerfectNumber(i)) {
                System.out.print(i + " ");
            }
        }
    }
}

