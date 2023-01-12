package com.eduardocode.springkafkaintegration.components.producers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

//@Component
public class SimpleProducerComponent extends ProducerWrapper implements CommandLineRunner {

    public SimpleProducerComponent(@Value(topicPropPath) String TOPIC) {
        super(TOPIC);
    }

    @Override
    public void run(String... args) {
        kafkaTemplate.send(TOPIC, "batch-key", "Sample message");
    }
}