package com.eduardocode.kafka.callbacks;

import com.eduardocode.kafka.producers.CheetosProducer;
import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

import static java.util.Objects.nonNull;

public class CheetosCallbackProducer {

    private final static Logger logger = LoggerFactory.getLogger(CheetosCallbackProducer.class);

    public static void main(String[] args) {
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092"); //kafka broker
        props.put(ProducerConfig.ACKS_CONFIG, "1"); // 0, 1, all
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);

        // performance prop
        props.put(ProducerConfig.LINGER_MS_CONFIG, "4");

        long startTime = System.currentTimeMillis();

        try(Producer<String, String> producer = new KafkaProducer<>(props)) {
            for (int i = 0; i < 10000; i++) {
                String index = String.valueOf(i);

                producer.send(
                        new ProducerRecord<String, String>("vanilla-topic", "vanilla-key", index),
                        new Callback() {

                            @Override
                            public void onCompletion(RecordMetadata metadata, Exception exception) {


                                if(nonNull(exception)) {
                                    logger.info("There was an error {} ", exception.getMessage());
                                } else {
                                    logger.info(
                                            "offset: {}, partition: {}, topic: {}",
                                            metadata.offset(), metadata.partition(), metadata.topic());
                                }
                            }
                        }
                );
            }

            producer.flush();
        }

        logger.info("Processing time = {} ms ", System.currentTimeMillis() - startTime);
    }
}
