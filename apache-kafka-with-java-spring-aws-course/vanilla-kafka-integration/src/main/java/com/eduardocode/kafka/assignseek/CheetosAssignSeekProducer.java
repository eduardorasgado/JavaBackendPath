package com.eduardocode.kafka.assignseek;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

// Consumer: partition 0
public class CheetosAssignSeekProducer {
    private final static Logger logger = LoggerFactory.getLogger(CheetosAssignSeekProducer.class);

    public static void main(String[] args) {
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092"); //kafka broker
        props.put(ProducerConfig.ACKS_CONFIG, "all"); // 0, 1, all
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getCanonicalName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getCanonicalName());
        props.put(ProducerConfig.LINGER_MS_CONFIG, "4");

        long startTime = System.currentTimeMillis();

        try(Producer<String, String> producer = new KafkaProducer<>(props)) {
            for (int i = 0; i < 100; i++) {
                producer.send(new ProducerRecord<String, String>("vanilla-topic", "vanilla-key", String.valueOf(i)));
            }

            producer.flush();
        }

        logger.info("Processing time = {} ms ", System.currentTimeMillis() - startTime);
    }
}