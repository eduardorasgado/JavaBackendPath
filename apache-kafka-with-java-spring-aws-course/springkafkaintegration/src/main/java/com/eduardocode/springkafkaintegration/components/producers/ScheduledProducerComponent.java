package com.eduardocode.springkafkaintegration.components.producers;

import io.micrometer.core.instrument.Meter;
import io.micrometer.core.instrument.MeterRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaProducerException;
import org.springframework.kafka.core.KafkaSendCallback;
import org.springframework.kafka.support.SendResult;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.List;

@Component
public class ScheduledProducerComponent extends ProducerWrapper {

    private static final Logger logger = LoggerFactory.getLogger(ScheduledProducerComponent.class);

    @Autowired
    private MeterRegistry meterRegistry;

    public ScheduledProducerComponent(@Value(topicPropPath) String TOPIC) {
        super(TOPIC);
    }

    private long count = 0;

    @Scheduled(fixedDelay = 1000, initialDelay = 100)
    public void run() {
        for (int i = 0; i < 12; i++) {
            ListenableFuture<SendResult<String, String>> future =
                    kafkaTemplate.send(TOPIC, String.format("batch-key-%d", count), String.format("Sample message %d", count));

            if(count == 0) {
                future.addCallback(getSendCallBack());
            }

            count++;
        }
    }

    private KafkaSendCallback<String, String> getSendCallBack() {
        return new KafkaSendCallback<String, String>() {
            @Override
            public void onFailure(KafkaProducerException e) {
                logger.error("Error sending message ", e);
            }

            @Override
            public void onSuccess(SendResult<String, String> result) {
                logger.info("[PRODUCER METRICS] Meters available: ");

                List<Meter> meters = meterRegistry.getMeters();
                for (Meter meter : meters) {
                    logger.info("Meter: {}", meter.getId().getName());
                }
            }
        };
    }
}