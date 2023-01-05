package com.eduardocode.producers;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;
import java.util.concurrent.ExecutionException;

public class SyncCheetosProducer {
    private final static Logger logger = LoggerFactory.getLogger(SyncCheetosProducer.class);

    public static void main(String[] args) {
        String mode = "[SYNC]";
        Properties props = new Properties();

        props.put("bootstrap.servers", "localhost:9092"); //kafka broker
        props.put("acks", "1");
        props.put("key.serializer", StringSerializer.class);
        props.put("value.serializer", StringSerializer.class);

        try(Producer<String, String> producer = new KafkaProducer<String, String>(props)) {
            for (int i = 0; i < 10000; i++) {
                String index = String.valueOf(i);

                producer.send(new ProducerRecord<String, String>(
                        "vanilla-topic",
                        mode + "vanilla-key-" + index,
                        "vanilla-value-" + index)
                ).get();
            }

            producer.flush();
        } catch (ExecutionException | InterruptedException e) {
            logger.error("[MESSAGE PRODUCER INTERRUPTED]", e);
        }
    }
}
