package com.eduardocode.kafka.producers;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

/*
This class is to check the order or the messages given the key we send to consumer

--------------ORDER PROBLEM AFTER RETRYING--------

if a message was unable to be sent, kafka producer will retry to send it, but, it will do it after sending
other messages, because at the time it fails to send message 1, it will send message 2 and 3 and then message 1.
To avoid getting this behavior and to be sure we are sending every message in order, we should use the property

max.in.flight.requests.per.connection = 1        (default value: 5)

 with this, kafka producer will try to send the missing message first and after accomplishing this task, it will go for
 the rest of the messages.

 We should be careful at the moment we configure this property to 1 because it will impact our producer throughput
 */
public class CheetosOrderedProducer {
    private final static Logger logger = LoggerFactory.getLogger(CheetosOrderedProducer.class);

    public static void main(String[] args) {

        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092"); //kafka broker
        props.put(ProducerConfig.ACKS_CONFIG, "1"); // 0, 1, all
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);

        props.put(ProducerConfig.LINGER_MS_CONFIG, "4");

        try(Producer<String, String> producer = new KafkaProducer<>(props)) {
            for (int i = 0; i < 100; i++) {
                String index = String.valueOf(i);

                //logger.info("message key: {}", "vanilla-key" + Integer.parseInt(index));

                producer.send(new ProducerRecord<>(
                        "vanilla-topic",
                        "vanilla-key-" + (Integer.parseInt(index) % 2 == 0 ? "2.1" : "3.1"),
                        index)
                );
            }

            producer.flush();
        }
    }
}