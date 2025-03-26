package com.quarks.notification.service;

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
public class NotificationService {
    private static final Logger log = LoggerFactory.getLogger(NotificationService.class);
    private final ObjectMapper objectMapper;
    private final KafkaProducerService kafkaProducerService;
    @Value("${email.sent.topic}")
    private String emailSentTopic;

    public NotificationService(ObjectMapper objectMapper, KafkaProducerService kafkaProducerService) {
        this.objectMapper = objectMapper;
        this.kafkaProducerService = kafkaProducerService;
    }

    @KafkaListener(topics = "bill-notification", groupId = "group_id")
    public void listenBillNotificationTopic(String message) throws JsonProcessingException {
        log.info("listenBillCalculationTopic message: {}", message);
        BillMessage bill = objectMapper.readerFor(BillMessage.class).readValue(message);
        doEmailNotification(bill);

        sendCompleteMessage(bill);
    }

    private void sendCompleteMessage(BillMessage bill) {
        String jsonMessage;
        try {
            jsonMessage = objectMapper.writeValueAsString(bill);
            kafkaProducerService.sendMessage(emailSentTopic, jsonMessage);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    private void doEmailNotification(BillMessage bill) {
        log.info("doEmailNotification bill: {}", bill);
        log.info("_____________________________________________________");
        log.info("NOTIFICATION EMAIL");
        log.info("Subject : Bill generated");
        log.info("Send to : {}", bill.getCustomerMessage().getEmailAddress());
        log.info("Due on : {}", bill.getDueDate());
        log.info("Paid Amount: {}", bill.getAmount());
        log.info("_____________________________________________________");
    }
}
