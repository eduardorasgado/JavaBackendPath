package com.eduardocode.springkafkaintegration.components.synced;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class SyncedComponent implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(SyncedComponent.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void run(String... args) throws Exception {
        logger.info("[" + this.getClass().getName() + " class run method was executed]");

        //kafkaTemplate.send()
    }
}
