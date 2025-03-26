package com.quarks.generation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication(scanBasePackages = {"com.quarks.database", "com.quarks.kafka", "com.quarks.generation"})
@EnableKafka
public class BillGenerationServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BillGenerationServiceApplication.class, args);
    }

}
