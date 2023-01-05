package com.eduardocode.producers;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class CheetosProducer {

    public static void main(String[] args) {
        Properties props = new Properties();

        props.put("bootstrap.servers", "localhost:9092"); //kafka broker
        props.put("acks", "1");
        props.put("key.serializer", StringSerializer.class);
        props.put("value.serializer", StringSerializer.class);

        try(Producer<String, String> producer = new KafkaProducer<String, String>(props)) {
            producer.send(new ProducerRecord<String, String>("vanilla-topic", "vanilla-key-3", "vanilla-value-3"));
        }
    }
}
