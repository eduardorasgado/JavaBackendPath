package com.eduardocode.springkafkaintegration.config;

import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConfiguration {

    public Map<String, Object> defineConsumerProperties() {
        Map<String, Object> props = new HashMap<>();
        return props;
    }
}
