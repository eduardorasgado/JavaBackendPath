package com.eduardocode.springkafkaintegration.components.producers;

import com.eduardocode.springkafkaintegration.components.TopicWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.kafka.core.KafkaProducerException;
import org.springframework.kafka.core.KafkaSendCallback;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

import static java.util.Objects.nonNull;

@Component
public class WithCallbackProducerComponent extends TopicWrapper implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(WithCallbackProducerComponent.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public WithCallbackProducerComponent(@Value(topicPropPath) String TOPIC) {
        super(TOPIC);
    }

    // we can run certain things on the application start by implementing CommandLineRunner
    @Override
    public void run(String... args) {
        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(
                TOPIC, "[CALLBACK PRODUCER COMPONENT MESSAGE] Producer is ready to send message");

        future.addCallback(getSendCallBack());
    }

    private KafkaSendCallback<String, String> getSendCallBack() {
        return new KafkaSendCallback<>() {
            @Override
            public void onSuccess(SendResult<String, String> result) {
                if(nonNull(result)) {
                    logger.info(
                            "Message sent: {}, partition: {}",
                            result.getRecordMetadata().offset(),
                            result.getRecordMetadata().partition());
                } else {
                    logger.warn("Warn: Message sent but [SendResult result] is null after sending message");
                }
            }

            @Override
            public void onFailure(Throwable ex) {
                logger.error("Error sending message ", ex);
            }

            @Override
            public void onFailure(KafkaProducerException e) {
                logger.error("Error sending message ", e);
            }
        };
    }
}
