package com.eduardocode.producers;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

public class CheetosProducer {
    private final static Logger logger = LoggerFactory.getLogger(CheetosProducer.class);

    public static void main(String[] args) {
        String mode = "[SYNC 5] ";
        Properties props = new Properties();

        props.put("bootstrap.servers", "localhost:9092"); //kafka broker
        props.put("acks", "1"); // 0, 1, all
        props.put("key.serializer", StringSerializer.class);
        props.put("value.serializer", StringSerializer.class);

        long startTime = System.currentTimeMillis();

        try(Producer<String, String> producer = new KafkaProducer<String, String>(props)) {
            for (int i = 0; i < 100000; i++) {
                String index = String.valueOf(i);

                producer.send(new ProducerRecord<String, String>(
                        "vanilla-topic",
                        mode + "vanilla-key-" + index,
                        "vanilla-value-" + index)
                );
            }

            producer.flush();
        }

        logger.info("Processing time = {} ms ", System.currentTimeMillis() - startTime);
    }
}