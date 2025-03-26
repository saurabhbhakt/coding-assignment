package org.quarks.learn.java8;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateTimeExample {
    public static void main(String[] args) {
        // Using LocalDate to get the current date
        LocalDate currentDate = LocalDate.now();
        System.out.println("Current Date: " + currentDate);  // Output: Current Date: 2025-03-05

        // Parsing and formatting a date
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date = LocalDate.parse("05/03/2025", formatter);
        System.out.println("Parsed Date: " + date);  // Output: Parsed Date: 2025-03-05
    }
}

