package com.eduardocode.springkafkaintegration.components.producers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledProducerComponent extends ProducerWrapper {

    public ScheduledProducerComponent(@Value(topicPropPath) String TOPIC) {
        super(TOPIC);
    }

    private long count = 0;

    @Scheduled(fixedDelay = 1000, initialDelay = 500)
    public void run() {
        kafkaTemplate.send(TOPIC, String.format("batch-key-%d", count), String.format("Sample message %d", count++));
    }
}