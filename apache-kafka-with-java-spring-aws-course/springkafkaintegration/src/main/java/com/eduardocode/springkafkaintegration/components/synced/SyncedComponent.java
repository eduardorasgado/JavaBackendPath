package com.eduardocode.springkafkaintegration.components.synced;

import com.eduardocode.springkafkaintegration.TopicWrapper;
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
public class SyncedComponent extends TopicWrapper implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(SyncedComponent.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public SyncedComponent(@Value(topicPropPath) String TOPIC) {
        super(TOPIC);
    }

    @Override
    public void run(String... args) {
        logger.info("[" + this.getClass().getSimpleName() + "] class run method is executed");

        try {
            kafkaTemplate.send(TOPIC, "[SYNC COMPONENT] Sent a message").get(500, TimeUnit.MILLISECONDS);
        } catch (ExecutionException | InterruptedException ex) {
            logger.error("[MESSAGE PRODUCER INTERRUPTED] ", ex);
        } catch (TimeoutException ex) {
            logger.error("[MESSAGE PRODUCER TIMEOUT] ", ex);
        }
    }
}
