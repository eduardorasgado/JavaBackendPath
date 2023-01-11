package com.eduardocode.springkafkaintegration.components.consumers;

import com.eduardocode.springkafkaintegration.components.TopicPathWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BatchListener extends TopicPathWrapper {

    private static final Logger logger = LoggerFactory.getLogger(BatchListener.class);

    /*
     * max.poll.interval.ms: defines the time between pool method executions
     * max.poll.records: Define maximum amount of registers returned by the pool method
     */
    @KafkaListener(topics = {topicPropPath}, groupId = "integration-batch-group", containerFactory = "batchListenerFactory",
            properties = { "max.poll.interval.ms:4000", "max.poll.records: 10"})
    public void listen(List<String> messages) {
        logger.info("[BATCH LISTENER: START] Messages received: ");

        for (String message : messages) {
            logger.info(message);
        }
        logger.info("[BATCH LISTENER: END]");
    }
}
