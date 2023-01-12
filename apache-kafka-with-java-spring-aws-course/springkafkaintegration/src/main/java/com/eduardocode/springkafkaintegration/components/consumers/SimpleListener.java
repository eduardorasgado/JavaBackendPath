package com.eduardocode.springkafkaintegration.components.consumers;

import com.eduardocode.springkafkaintegration.components.TopicPathWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

//@Component
public class SimpleListener extends TopicPathWrapper {

    private static final Logger logger = LoggerFactory.getLogger(SimpleListener.class);

    @KafkaListener(topics = {topicPropPath}, groupId = "integration-group", containerFactory = "simpleListenerFactory")
    public void listen(String message) {
        logger.info("[SIMPLE LISTENER] Message received: {}", message);
    }
}
