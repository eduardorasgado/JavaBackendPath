package com.eduardocode.springkafkaintegration;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.prometheus.PrometheusConfig;
import io.micrometer.prometheus.PrometheusMeterRegistry;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@ComponentScan(
        basePackages = {
                "com.eduardocode.springkafkaintegration.components",
                "com.eduardocode.springkafkaintegration.config"
        })
public class SpringKafkaIntegrationApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringKafkaIntegrationApplication.class, args);
    }

    //@Scheduled(fixedDelay = 1000, initialDelay = 500)
    public void print() {
        LoggerFactory.getLogger(SpringKafkaIntegrationApplication.class).info("Cheetos rocks!");
    }
}
