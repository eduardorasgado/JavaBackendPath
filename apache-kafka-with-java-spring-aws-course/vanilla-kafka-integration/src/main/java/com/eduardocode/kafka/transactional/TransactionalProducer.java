package com.eduardocode.kafka.transactional;

import com.eduardocode.kafka.producers.CheetosProducer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

public class TransactionalProducer {

    private final static Logger logger = LoggerFactory.getLogger(TransactionalProducer.class);

    public static void main(String[] args) {
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092"); //kafka broker
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);

        // transactional feature key config -------------------
        props.put(ProducerConfig.ACKS_CONFIG, "all");
        props.put(ProducerConfig.TRANSACTIONAL_ID_CONFIG, "vanilla-producer-id");
        // -------------------

        // performance props
        props.put(ProducerConfig.LINGER_MS_CONFIG, "4");

        long startTime = System.currentTimeMillis();

        try(Producer<String, String> producer = new KafkaProducer<>(props)) {
            try {
                producer.initTransactions();
                producer.beginTransaction();

                for (int i = 0; i < 100000; i++) {
                    String index = String.valueOf(i);

                    producer.send(new ProducerRecord<String, String>(
                            "vanilla-topic",
                            "vanilla-key",
                            index)
                    );

                    // at the moment this Exception is thrown, transaction is not able to be commited as expected
                    // this causes TransactionalConsumer to ignore every message was created until the moment this exception is thrown
                    if(i >= 90000) {
                        throw new Exception("Unexpected exception");
                    }
                }

                producer.commitTransaction();
                producer.flush();
            } catch (Exception ex) {
                logger.error("Error ", ex);

                producer.abortTransaction();
            }
        }

        logger.info("Processing time = {} ms ", System.currentTimeMillis() - startTime);
    }
}
