package com.quarks.calculation.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.quarks.kafka.dto.BillMessage;
import com.quarks.kafka.dto.CustomerMessage;
import com.quarks.kafka.service.KafkaProducerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Random;

@Service
public class BillCalculationService {

    private static final Logger log = LoggerFactory.getLogger(BillCalculationService.class);
    private final ObjectMapper mapper;
    private final KafkaProducerService kafkaProducerService;

    @Value("${bill.generation.topic}")
    private String generationTopic;

    public BillCalculationService(ObjectMapper mapper, KafkaProducerService kafkaProducerService) {
        this.mapper = mapper;
        this.kafkaProducerService = kafkaProducerService;
    }


    @KafkaListener(topics = "bill-calculation", groupId = "group_id")
    public void listenBillCalculationTopic(String message) throws JsonProcessingException {
        log.info("message: {}", message);
        CustomerMessage customerMessage = mapper.readValue(message, CustomerMessage.class);
        sendCalculationMessage(calculateBill(customerMessage));
    }

    private void sendCalculationMessage(BillMessage bill) throws JsonProcessingException {
        log.info("billMessage: {}", bill);
        String billMessage = mapper.writeValueAsString(bill);
        kafkaProducerService.sendMessage(generationTopic, billMessage);
    }

    private BillMessage calculateBill(CustomerMessage customer) {
        log.info("customer: {}", customer);
        Random random = new Random();
        LocalDate dueDate = LocalDate.now().plusDays(random.nextInt(10)); // Random due date within 10 days
        Double amount = (random.nextDouble() * 1000) + 50;
        return BillMessage.builder()
                .id(customer.getId() + dueDate.getYear() + dueDate.getMonthValue())
                .amount(amount)
                .dueDate(dueDate)
                .customerMessage(customer)
                .build();
    }
}

