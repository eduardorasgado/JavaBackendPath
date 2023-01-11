package com.eduardocode.springkafkaintegration.components.producers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

public class ProducerWrapper extends TopicWrapper {

    @Autowired
    protected KafkaTemplate<String, String> kafkaTemplate;

    public ProducerWrapper(String TOPIC) {
        super(TOPIC);
    }
}
