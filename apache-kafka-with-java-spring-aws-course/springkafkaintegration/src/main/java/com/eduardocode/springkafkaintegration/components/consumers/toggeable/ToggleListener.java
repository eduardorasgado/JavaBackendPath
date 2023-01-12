package com.eduardocode.springkafkaintegration.components.consumers.toggeable;

import com.eduardocode.springkafkaintegration.components.TopicPathWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.KafkaListenerEndpointRegistry;
import org.springframework.stereotype.Component;

import java.util.Objects;

import static java.util.Objects.nonNull;

@Component
public class ToggleListener extends TopicPathWrapper {

    private static final Logger logger = LoggerFactory.getLogger(ToggleListener.class);

    @Autowired
    private KafkaListenerEndpointRegistry listenerRegistry; // registry to be able to toggle the ToggeableBatchListener class

    @Value("${consumer.listener.id}")
    private String listenerId; // batch listener id

    private String TOGGLE_ON = "ON";
    private String TOGGLE_OFF = "OFF";

    @KafkaListener(topics = {topicPropPath}, groupId = "integration-group", containerFactory = "simpleListenerFactory")
    public void listen(String message) {
        if(nonNull(message)) {
            if(message.toUpperCase().equals(TOGGLE_ON)) {
                logger.info("[TOGGLE LISTENER] BATCH LISTENER > TURNED ON");
                Objects.requireNonNull(listenerRegistry.getListenerContainer(listenerId)).start();
            }
            else if (message.toUpperCase().equals(TOGGLE_OFF)) {
                logger.info("[TOGGLE LISTENER] BATCH LISTENER > TURNED OFF");
                Objects.requireNonNull(listenerRegistry.getListenerContainer(listenerId)).stop();
            }
        }
    }
}
