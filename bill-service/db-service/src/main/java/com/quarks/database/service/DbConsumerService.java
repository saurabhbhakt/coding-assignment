package com.quarks.database.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.quarks.database.entity.Bill;
import com.quarks.database.entity.BillStatus;
import com.quarks.kafka.dto.BillMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DbConsumerService {
    private final ObjectMapper objectMapper;
    private final CustomerService customerService;

    public DbConsumerService(ObjectMapper objectMapper, CustomerService customerService) {
        this.objectMapper = objectMapper;
        this.customerService = customerService;
    }

    @KafkaListener(topics = "bill-email-sent", groupId = "group_id")
    public void listenBillEmailSentTopic(String message) throws JsonProcessingException {
        log.info("message : {}", message);
        BillMessage billMessage = objectMapper.readerFor(BillMessage.class).readValue(message);
        Bill bill = Bill.builder()
                .id(billMessage.getId())
                .amount(billMessage.getAmount())
                .dueDate(billMessage.getDueDate())
                .customerId(billMessage.getCustomerMessage().getId())
                .status(BillStatus.SEND)
                .build();
        customerService.addBill(bill);
    }
}
