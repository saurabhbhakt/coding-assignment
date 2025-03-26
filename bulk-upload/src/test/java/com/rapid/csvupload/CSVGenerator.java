package com.rapid.csvupload;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class CSVGenerator {
    public static void main(String[] args) {
        String fileName = "employees.csv";

        String[] names = {"John Doe", "Jane Smith", "Alice Brown", "Bob White", "Charlie Green"};
        String[] emails = {"john@example.com", "jane@example.com", "alice@example.com", "bob@example.com", "charlie@example.com"};
        String[] phones = {"1234567890", "9876543210", "4561237890", "7890123456", "3216549870"};
        String[] streets = {"123 Main St", "456 Elm St", "789 Oak St", "321 Pine St", "654 Maple St"};
        String[] cities = {"New York", "Los Angeles", "Chicago", "Houston", "San Francisco"};
        String[] states = {"NY", "CA", "IL", "TX", "CA"};
        String[] zipCodes = {"10001", "90001", "60601", "77001", "94101"};
        Random random = new Random();

        try (FileWriter writer = new FileWriter(fileName)) {
            // Write CSV header
            writer.append("ID,Name,Email,Phone,Street,City,State,ZipCode\n");

            // Generate 100 records
            for (int i = 1; i <= 100; i++) {
                String name = names[random.nextInt(names.length)];
                String email = emails[random.nextInt(emails.length)];
                String phone = phones[random.nextInt(phones.length)];
                String street = streets[random.nextInt(streets.length)];
                String city = cities[random.nextInt(cities.length)];
                String state = states[random.nextInt(states.length)];
                String zipCode = zipCodes[random.nextInt(zipCodes.length)];

                writer.append(i + "," + name + "," + email + "," + phone + "," + street + "," + city + "," + state + "," + zipCode + "\n");
            }

            System.out.println("CSV file generated successfully: " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
