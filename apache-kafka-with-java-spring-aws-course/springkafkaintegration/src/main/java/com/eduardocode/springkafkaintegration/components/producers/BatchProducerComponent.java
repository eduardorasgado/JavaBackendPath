package com.eduardocode.springkafkaintegration.components.producers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

//@Component
public class BatchProducerComponent extends ProducerWrapper implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(BatchProducerComponent.class);

    public BatchProducerComponent(@Value(topicPropPath) String TOPIC) {
        super(TOPIC);
    }

    @Override
    public void run(String... args) {
        logger.info("[BATCH PRODUCER COMPONENT] Started.");
        String BASE_KEY = "batch-key-";

        for (int i = 0; i < 100; i++) {

            kafkaTemplate.send(TOPIC, BASE_KEY + String.valueOf(i), String.format("Sample message %d", i));
        }
    }
}
