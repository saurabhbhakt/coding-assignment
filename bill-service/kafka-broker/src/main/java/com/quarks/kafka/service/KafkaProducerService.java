package com.quarks.kafka.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaProducerService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public KafkaProducerService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
        log.info("kafka producer service started");
    }

    public void sendMessage(String topic, String message) {
        log.info("send message to topic {}", topic);
        log.info("send message {}", message);
        kafkaTemplate.send(topic, message);
    }
}
