package com.quarks.database.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.quarks.database.entity.Customer;
import com.quarks.kafka.dto.CustomerMessage;
import com.quarks.kafka.service.KafkaProducerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@Service
public class DbProducerService {
    private final KafkaProducerService kafkaProducerService;
    private final CustomerService customerService;
    private final ObjectMapper objectMapper;

    @Value("${bill.calculation.topic}")
    private String calculationTopic;

    public DbProducerService(KafkaProducerService kafkaProducerService, CustomerService customerService, ObjectMapper objectMapper) {
        this.kafkaProducerService = kafkaProducerService;
        this.customerService = customerService;
        this.objectMapper = objectMapper;
    }

    public void sendToCalculateBills() {
        log.info("sendToCalculateBills");
        LocalDate currentDate = LocalDate.now();
        LocalDate startOfMonth = currentDate.withDayOfMonth(1);
        LocalDate endOfMonth  = currentDate.withDayOfMonth(1).plusMonths(1).minusDays(1);
        List<Customer> customers = customerService.findCustomersWithNoBillsForCurrentMonth(startOfMonth, endOfMonth);
        log.info("customers size: {}", customers.size());
        customers.forEach(customer -> {
            CustomerMessage customerMessage = CustomerMessage.builder()
                    .id(customer.getId())
                    .customerName(customer.getCustomerName())
                    .emailAddress(customer.getEmailAddress())
                    .phoneNumber(String.valueOf(customer.getPhoneNumber()))
                    .build();
            sendCalculationMessage(customerMessage);
        });
    }

    private void sendCalculationMessage(CustomerMessage customerMessage) {
        try {
            String jsonMessage = objectMapper.writeValueAsString(customerMessage);
            kafkaProducerService.sendMessage(calculationTopic, jsonMessage);
        } catch (JsonProcessingException e) {
            log.error(e.getMessage(), e);
        }

    }
}
