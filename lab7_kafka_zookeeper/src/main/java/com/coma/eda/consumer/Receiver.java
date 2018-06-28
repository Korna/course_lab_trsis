package com.coma.eda.consumer;

import java.util.concurrent.CountDownLatch;

import com.coma.db.model.Record;
import com.coma.eda.producer.Sender;
import com.coma.service.ExhibitService;
import com.google.common.collect.Iterables;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.KafkaListenerEndpointRegistry;

public class Receiver {

    @Autowired
    private KafkaListenerEndpointRegistry kafkaListenerEndpointRegistry;


    @Autowired
    private Receiver receiver;

    @Autowired
    private Sender sender;


    @Autowired
    private ExhibitService exhibitService;

    private static final Logger LOGGER = LoggerFactory.getLogger(Receiver.class);

    private CountDownLatch latch = new CountDownLatch(1);

    public CountDownLatch getLatch() {
        return latch;
    }

    @KafkaListener(topics = "${kafka.topic.helloworld}")
    public void receive(String payload) {

        Record record = new Record();
        record.setAuthor(payload);
        System.out.print("payload" + payload);
        LOGGER.info(Iterables.size(exhibitService.listAll()) + "");
        exhibitService.add(record);
        LOGGER.info(Iterables.size(exhibitService.listAll()) + "");
        LOGGER.info("Received='{}'", payload);
        latch.countDown();
    }
}
