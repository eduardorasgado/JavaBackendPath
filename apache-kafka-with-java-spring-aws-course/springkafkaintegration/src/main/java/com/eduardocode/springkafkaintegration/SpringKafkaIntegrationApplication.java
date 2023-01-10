package com.eduardocode.springkafkaintegration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class SpringKafkaIntegrationApplication implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(SpringKafkaIntegrationApplication.class);

    private static final String TOPIC = "integration-topic";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public static void main(String[] args) {
        SpringApplication.run(SpringKafkaIntegrationApplication.class, args);
    }

    @KafkaListener(topics = {TOPIC}, groupId = "integration-group")
    public void listen(String message) {
        logger.info("Message received: {}", message);
    }

    // we can run certrain things on the application start by implementing CommandLineRunner
    @Override
    public void run(String... args) throws Exception {
        kafkaTemplate.send(TOPIC, "[Producer/Consumer Application] Producer is ready to send message");
    }
}
