package com.eduardocode.springkafkaintegration.config;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConsumerConfiguration {

    @Value("${broker.server.path}")
    private String consumerServerPath;

    @Value("${consumer.auto.commit.interval.ms.config}")
    private int consumerAutoCommitIntervalInMs;

    @Value("${consumer.session.timeout.ms}")
    private int consumerSessionTimeoutInMs;

    private Map<String, Object> consumerProperties() {
        Map<String, Object> props = new HashMap<>();

        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, consumerServerPath);
        //props.put(ConsumerConfig.GROUP_ID_CONFIG, "cheetos-group");
        //props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, true);
        //props.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, String.valueOf(consumerAutoCommitIntervalInMs));
        props.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, String.valueOf(consumerSessionTimeoutInMs));

        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);

        return props;
    }

    @Bean
    public ConsumerFactory<String, String> consumerFactory() {
        return new DefaultKafkaConsumerFactory<>(consumerProperties());
    }

    @Bean(name = "simpleListenerFactory")
    public ConcurrentKafkaListenerContainerFactory<String, String> simpleListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, String> listenerContainerFactory = new ConcurrentKafkaListenerContainerFactory<>();
        listenerContainerFactory.setConsumerFactory(consumerFactory());

        return listenerContainerFactory;
    }

    @Bean(name = "batchListenerFactory")
    public ConcurrentKafkaListenerContainerFactory<String, String> batchListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, String> listenerContainerFactory = new ConcurrentKafkaListenerContainerFactory<>();
        listenerContainerFactory.setConsumerFactory(consumerFactory());

        listenerContainerFactory.setBatchListener(true);
        listenerContainerFactory.setConcurrency(3);

        return listenerContainerFactory;
    }
}
