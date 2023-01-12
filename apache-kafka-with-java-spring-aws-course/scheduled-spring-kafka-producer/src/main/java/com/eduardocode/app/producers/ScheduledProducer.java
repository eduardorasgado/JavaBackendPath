package com.eduardocode.app.producers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Component
public class ScheduledProducer implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(ScheduledProducer.class);

    @Autowired
    protected KafkaTemplate<String, String> kafkaTemplate;

    private final String topicPropPath = "${broker.topic}";
    private final String TOPIC;

    public ScheduledProducer(@Value(topicPropPath) String TOPIC) {
        this.TOPIC = TOPIC;
    }

    public static long count = 0;

    private final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

    @Override
    public void run(String... args) {
        logger.info("[THREAD PRODUCER COMPONENT] is now running.");
        String BASE_KEY = "batch-key";

        executorService.scheduleAtFixedRate(() -> {
            kafkaTemplate.send(TOPIC, BASE_KEY, String.format("Sample message %d", count++));
        },0, 1000, TimeUnit.MILLISECONDS);
    }
}
