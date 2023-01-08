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
--------------IDEMPOTENT PRODUCERS--------------

To be able to be sure we are receiving a single value of a message instead of duplicate entries we can use the property

enable.idempotence = true

with this configuration we activate a unique key for every sent message and consumer wont insert any duplicates.

To be able to set and having this feature working we must fulfill the next restrictions:
max.in.flight.requests.per.connection <= 5 (default value: 5)
retries > 0     (default value is max int supported)
acks > all

if any of these are fulfilled then we will get a ConfigException

 */
public class CheetosProducer {
    private final static Logger logger = LoggerFactory.getLogger(CheetosProducer.class);

    public static void main(String[] args) {
        String mode = "[ASYNC M -4s] ";

        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092"); //kafka broker
        props.put(ProducerConfig.ACKS_CONFIG, "1"); // 0, 1, all
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);

        // performance props
        props.put(ProducerConfig.LINGER_MS_CONFIG, "4");
        //props.put(ProducerConfig.LINGER_MS_CONFIG, "4000");
        //props.put(ProducerConfig.BATCH_SIZE_CONFIG, Integer.toString(16 * 1024));

        long startTime = System.currentTimeMillis();

        try(Producer<String, String> producer = new KafkaProducer<>(props)) {
            for (int i = 0; i < 100; i++) {
                String index = String.valueOf(i);

                //logger.info("message key: {}", "vanilla-key" + Integer.parseInt(index));

                producer.send(new ProducerRecord<String, String>(
                        "vanilla-topic",
                        mode + "vanilla-key" + Integer.parseInt(index),
                        index)
                );
            }

            producer.flush();
        }

        logger.info("Processing time = {} ms ", System.currentTimeMillis() - startTime);
    }
}