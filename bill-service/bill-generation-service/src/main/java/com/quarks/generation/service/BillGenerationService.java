package com.quarks.generation.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.quarks.kafka.dto.BillMessage;
import com.quarks.kafka.service.KafkaProducerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class BillGenerationService {
    private static final Logger log = LoggerFactory.getLogger(BillGenerationService.class);
    private final ObjectMapper objectMapper;
    private final KafkaProducerService kafkaProducerService;

    @Value("${bill.notification.topic}")
    private String notificationTopic;

    public BillGenerationService(ObjectMapper objectMapper, KafkaProducerService kafkaProducerService) {
        this.objectMapper = objectMapper;
        this.kafkaProducerService = kafkaProducerService;
        log.info("Bill Generation Service");
    }

    @KafkaListener(topics = "bill-generation", groupId = "group_id")
    public void listenBillCalculationTopic(String message) throws JsonProcessingException {
        log.info("message : {}", message);
        BillMessage bill = objectMapper.readerFor(BillMessage.class).readValue(message);
        printBill(bill);
        sendEmailNotification(bill);
    }


    private void sendEmailNotification(BillMessage bill) throws JsonProcessingException {
        String billMessage = objectMapper.writeValueAsString(bill);
        kafkaProducerService.sendMessage(notificationTopic, billMessage);
    }

    private void printBill(BillMessage bill) {
        log.info("----------------------------------------------");
        log.info("| Name : {}", bill.getCustomerMessage().getCustomerName());
        log.info("| Email : {}", bill.getCustomerMessage().getEmailAddress());
        log.info("| Due Date : {}", bill.getDueDate());
        log.info("| Amount : {}", bill.getAmount().toString());
        log.info("----------------------------------------------");
    }
}
