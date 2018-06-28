package com.coma.eda.producer;

import com.coma.eda.consumer.Receiver;
import com.coma.service.ExhibitService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.config.KafkaListenerEndpointRegistry;
import org.springframework.kafka.core.KafkaTemplate;

public class Sender {
    private static final Logger LOGGER = LoggerFactory.getLogger(Sender.class);

    @Autowired
    private KafkaListenerEndpointRegistry kafkaListenerEndpointRegistry;

    @Autowired
    private ExhibitService exhibitService;

    @Autowired
    private Receiver receiver;

    @Autowired
    private Sender sender;


    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void send(String topic, String payload) {
        LOGGER.info("Sent='{}' to topic='{}'", payload, topic);
        System.out.print(payload + topic);
        kafkaTemplate.send(topic, payload);

    }

}
