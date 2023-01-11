package com.eduardocode.springkafkaintegration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaProducerException;
import org.springframework.kafka.core.KafkaSendCallback;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;

import static java.util.Objects.nonNull;

@SpringBootApplication
@ComponentScan(
        basePackages = {
        "com.eduardocode.springkafkaintegration.components.synced"
        })
public class SpringKafkaIntegrationApplication extends TopicWrapper implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(SpringKafkaIntegrationApplication.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public SpringKafkaIntegrationApplication(@Value(topicPropPath) String TOPIC) {
        super(TOPIC);
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringKafkaIntegrationApplication.class, args);
    }

    @KafkaListener(topics = {topicPropPath}, groupId = "integration-group")
    public void listen(String message) {
        logger.info("Message received: {}", message);
    }

    // we can run certain things on the application start by implementing CommandLineRunner
    @Override
    public void run(String... args) throws Exception {
        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(
                TOPIC, "[Producer/Consumer Application] Producer is ready to send message");

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
