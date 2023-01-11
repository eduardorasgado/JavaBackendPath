package com.eduardocode.springkafkaintegration.components.producers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@Component
public class SyncedProducerComponent extends ProducerWrapper implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(SyncedProducerComponent.class);

    public SyncedProducerComponent(@Value(topicPropPath) String TOPIC) {
        super(TOPIC);
    }

    @Override
    public void run(String... args) {
        logger.info("[" + this.getClass().getSimpleName() + "] class run method is executed");

        try {
            kafkaTemplate.send(TOPIC, "[SYNC PRODUCER COMPONENT MESSAGE] Sent a message").get(500, TimeUnit.MILLISECONDS);
        } catch (ExecutionException | InterruptedException ex) {
            logger.error("[MESSAGE PRODUCER INTERRUPTED] ", ex);
        } catch (TimeoutException ex) {
            logger.error("[MESSAGE PRODUCER TIMEOUT] ", ex);
        }
    }
}
