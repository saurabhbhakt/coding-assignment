package com.quarks.database;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(scanBasePackages = {"com.quarks.database", "com.quarks.kafka"})
@EnableScheduling
public class DbServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(DbServiceApplication.class, args);
    }
}
