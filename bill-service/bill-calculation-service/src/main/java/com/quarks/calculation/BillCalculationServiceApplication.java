package com.quarks.calculation;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(scanBasePackages = {"com.quarks.kafka", "com.quarks.calculation"})
@EnableScheduling
@EnableKafka
public class BillCalculationServiceApplication {

    public static void main(String[] args) {

        SpringApplication.run(BillCalculationServiceApplication.class, args);
    }

}
