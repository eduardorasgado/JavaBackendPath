package com.eduardocode.springkafkaintegration.components.producers;

import io.micrometer.core.instrument.Meter;
import io.micrometer.core.instrument.MeterRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProducerMetricComponent {

    private static final Logger logger = LoggerFactory.getLogger(ProducerMetricComponent.class);

    @Autowired
    private MeterRegistry meterRegistry;

    @Scheduled(fixedDelay = 2000, initialDelay = 500)
    public void messageCountMetric() {
        logger.info("[PRODUCER METRICS] Count: {}",
                Double.toString(meterRegistry.get("kafka.producer.record.send.total").functionCounter().count()));
    }
}
